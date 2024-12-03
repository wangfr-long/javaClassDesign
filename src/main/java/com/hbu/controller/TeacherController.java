package com.hbu.controller;
import com.hbu.common.result.Result;
import com.hbu.pojo.dto.StudentDTO;
import com.hbu.pojo.dto.TeacherDTO;
import com.hbu.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName TeacherController
 * @Description TODO
 * @Author awei
 * @Date 2024/12/1 10:55
 */
@RestController
@RequestMapping("/api/teacher")
@Slf4j
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    @PostMapping
    public Result add(@RequestBody TeacherDTO teacherDTO){
        log.info("添加新的教师:{}",teacherDTO.getName());
        return teacherService.add(teacherDTO);
    }
    @GetMapping("/search")
    public Result select(@RequestBody TeacherDTO teacherDTO){
        log.info("查询教师信息：{}",teacherDTO);
        return teacherService.select(teacherDTO);
    }
    @PutMapping
    public Result update(@RequestBody TeacherDTO teacherDTO){
            log.info("修改教师信息:{}",teacherDTO);
            return teacherService.update(teacherDTO);
    }
    @GetMapping("/course/{id}")
    public Result selectCourse(@PathVariable Long id){
        return teacherService.selectCourse(id);
    }
}
