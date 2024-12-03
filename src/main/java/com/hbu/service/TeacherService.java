package com.hbu.service;

import com.hbu.common.result.Result;
import com.hbu.pojo.dto.TeacherDTO;

public interface TeacherService {
    Result add(TeacherDTO teacherDTO);

    Result select(TeacherDTO teacherDTO);

    Result update(TeacherDTO teacherDTO);

    Result selectCourse(Long id);
}
