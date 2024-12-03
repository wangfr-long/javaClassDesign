package com.hbu.controller;

import com.hbu.common.result.Result;
import com.hbu.pojo.dto.CourseDTO;
import com.hbu.pojo.dto.StudentDTO;
import com.hbu.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName CourseController
 * @Description TODO
 * @Author awei
 * @Date 2024/12/1 12:41
 */
@RestController
@RequestMapping("/api/course")
@Slf4j
public class CourseController {
    @Resource
    private CourseService courseService;
    @PostMapping
    public Result add(@RequestBody CourseDTO courseDTO){
        log.info("添加新的课程");
        return courseService.add(courseDTO);
    }
    @GetMapping("/all")
    public Result selectAll(){
        log.info("查询所有课程");
        return courseService.selectAll();
    }
}
