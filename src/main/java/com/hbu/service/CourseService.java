package com.hbu.service;

import com.hbu.common.result.Result;
import com.hbu.pojo.dto.CourseDTO;

public interface CourseService {
    Result add(CourseDTO courseDTO);

    Result selectAll();
}
