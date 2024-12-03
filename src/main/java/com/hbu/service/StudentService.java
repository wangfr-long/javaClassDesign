package com.hbu.service;

import com.hbu.common.result.Result;
import com.hbu.pojo.dto.StudentDTO;

public interface StudentService {
    void add(StudentDTO studentDTO);

    Result selectById(String studentId);

    Result update(StudentDTO studentDTO);

    Result CourseSelect(Long id);

    Result selectCourse(String studentId);
}
