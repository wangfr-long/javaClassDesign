package com.hbu.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.hbu.common.result.Result;
import com.hbu.mapper.CourseMapper;
import com.hbu.mapper.TeacherMapper;
import com.hbu.pojo.dto.TeacherDTO;
import com.hbu.pojo.entity.Courses;
import com.hbu.pojo.entity.Teacher;
import com.hbu.pojo.vo.TeacherCourseVO;
import com.hbu.pojo.vo.TeacherVO;
import com.hbu.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TeacherServiceImpl
 * @Description TODO
 * @Author awei
 * @Date 2024/12/1 11:03
 */
@Service
public class  TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private CourseMapper courseMapper;
    @Override
    public Result add(TeacherDTO teacherDTO) {
        Teacher teacher = BeanUtil.copyProperties(teacherDTO, Teacher.class);
        teacherMapper.add(teacher);
        return Result.success();
    }

    @Override
    public Result select(TeacherDTO teacherDTO) {
        List<TeacherVO> teachers= teacherMapper.select(teacherDTO);
        return Result.success(teachers);
    }

    @Override
    public Result update(TeacherDTO teacherDTO) {
        teacherMapper.update(teacherDTO);
        return Result.success();
    }

    @Override
    public Result selectCourse(Long id) {
        List<Courses>courses=  courseMapper.selectByTeacherId(id);
        List<TeacherCourseVO> TeacherVOs =new ArrayList<>();
        for (Courses course:courses){
            TeacherCourseVO teacherCourseVO=new TeacherCourseVO();
            teacherCourseVO.setStudentNumber(course.getOriginalNumber()-course.getNumber());
            BeanUtils.copyProperties(course,teacherCourseVO);
            TeacherVOs.add(teacherCourseVO);
        }
        return Result.success(TeacherVOs);
    }
}
