package com.hbu.Listener;

import com.hbu.mapper.CourseMapper;
import com.hbu.mapper.StudentMapper;
import com.hbu.pojo.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName SpringRabbitMqListener
 * @Description TODO
 * @Author awei
 * @Date 2024/12/3 14:21
 */
@Component
@Slf4j
public class SpringRabbitMqListener {
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private CourseMapper courseMapper;
    @RabbitListener(queues = "simple.queue")
    public void Lisen(Map msg){
       log.info("监听到消息：{}",msg.get("studentId"));
       log.info("消息发送时间：{}",msg.get("courseId"));
       String studentId = (String) msg.get("studentId");
       Long id = (Long) msg.get("courseId");
           //3：更新选课人数
        courseMapper.updateCourseNumber(id);
        //2.1:查询学生选课信息
        Student student = studentMapper.selectById(studentId);
        String classId = student.getClassId();
        classId=classId+id+",";
        studentMapper.CourseSelect(classId,studentId);
        log.info("选课成功");
    }
}
