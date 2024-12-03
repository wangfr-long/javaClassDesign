package com.hbu.controller;

import com.hbu.common.result.Result;
import com.hbu.pojo.dto.StudentDTO;
import com.hbu.pojo.dto.TeacherDTO;
import com.hbu.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName StudentController
 * @Description TODO
 * @Author awei
 * @Date 2024/11/30 15:58
 */
@RestController
@RequestMapping("/api/student")
@Slf4j
public class StudentController {
    @Resource
    private StudentService studentService;
    /**
     * 添加学生
     * @param studentDTO
     * @return
     */
    @PostMapping
    public Result add(@RequestBody StudentDTO studentDTO){
        log.info("添加新的学生");
        studentService.add(studentDTO);
        return Result.success();
    }
    /**
     * 查询学生
     * @param studentId
     * @return
     */
    @GetMapping("/info/{studentId}")
    public Result selectById(@PathVariable String studentId){
        log.info("查询学号为：{}",studentId);
        return studentService.selectById(studentId);
    }
    /**
     * 修改学生信息
     * @param studentDTO
     * @return
     */
    @PutMapping
    public Result update(@RequestBody StudentDTO studentDTO){
        log.info("修改学生信息:{}",studentDTO);
        return studentService.update(studentDTO);
    }
    @PutMapping("/course")
    public Result CourseSelect(Long id){
        id=9L;
        log.info("学生选课:{}",id);
        return studentService.CourseSelect(id);
    }
    @GetMapping("/course/{studentId}")
    public Result selectCourse(@PathVariable String studentId){
        return studentService.selectCourse(studentId);
    }
}
