package com.hbu.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.hbu.common.context.ExceptionContext;
import com.hbu.common.exception.StudentNotExistException;
import com.hbu.common.exception.StudentRepetitionException;
import com.hbu.common.result.Result;
import com.hbu.mapper.CourseMapper;
import com.hbu.mapper.StudentMapper;
import com.hbu.pojo.dto.StudentDTO;
import com.hbu.pojo.entity.Courses;
import com.hbu.pojo.entity.Student;
import com.hbu.pojo.vo.StudentVO;
import com.hbu.service.StudentService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author awei
 * @Date 2024/11/30 16:00
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RabbitTemplate rabbitTemplate;
    public static final DefaultRedisScript COURSE_SELECT_LUA;

    static {
        //初始化
        COURSE_SELECT_LUA = new DefaultRedisScript<>();
        //定位到lua脚本的位置
        COURSE_SELECT_LUA.setLocation(new ClassPathResource("course.lua"));
        //设置lua脚本的返回值
        COURSE_SELECT_LUA.setResultType(Long.class);
    }
    @Override
    public void add(StudentDTO studentDTO) {
        if (studentMapper.selectById(studentDTO.getStudentId()) != null) {
            throw new StudentRepetitionException(ExceptionContext.STUDENT_REPETITIONEXCEPTION);
        }
        Student student = BeanUtil.copyProperties(studentDTO, Student.class);
        studentMapper.add(student);
    }

    @Override
    public Result selectById(String studentId) {
        Student student = studentMapper.selectById(studentId);
        if (student==null){
            throw new StudentNotExistException(ExceptionContext.STUDENT_NOT_EXIST);
        }
        String classId = student.getClassId();
        String[] classes = classId.split(",");
        StudentVO studentVO = BeanUtil.copyProperties(student, StudentVO.class);
        studentVO.setClasses(classes);
        return Result.success(studentVO);
    }

    @Override
    public Result update(StudentDTO studentDTO) {
        studentMapper.update(studentDTO);
        return Result.success();
    }

    @Override
    @Transactional
    public Result CourseSelect(Long id) {
        //1:查询课程是否可选
    /*  Long number =  courseMapper.selectNumber(id);
      if (number<=0){
          return Result.error(ExceptionContext.COURSES_NOT_AVAILABLE);
      }*/

        //2：选课
        String studentId = "123456";//模拟从登录信息中获取
        Long res = (Long) stringRedisTemplate.execute(COURSE_SELECT_LUA,
                Collections.emptyList(),id.toString()
        );
        if (res==1){
            return Result.error(ExceptionContext.COURSES_NOT_AVAILABLE);
        }
      /*  //3：更新选课人数
        courseMapper.updateCourseNumber(id);
        //2.1:查询学生选课信息
        Student student = studentMapper.selectById(studentId);
        String classId = student.getClassId();
        classId=classId+id+",";
        studentMapper.CourseSelect(classId,studentId);*/
        HashMap<String, Object> map = new HashMap<>();
        map.put("studentId",studentId);
        map.put("courseId",id);
        rabbitTemplate.convertAndSend("simple.queue",map);
        return Result.success();
    }

    @Override
    public Result selectCourse(String studentId) {
        Student student = studentMapper.selectById(studentId);
        String classId = student.getClassId();
        String[] classes = classId.split(",");
        //将字符串转换为数组
        long[] array = Arrays.stream(classes).mapToLong(Long::parseLong).toArray();
        List<Courses> courses= courseMapper.selectByIds(array);
        return Result.success(courses);
    }
}
