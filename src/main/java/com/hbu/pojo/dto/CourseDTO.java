package com.hbu.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CourseDTO
 * @Description TODO
 * @Author awei
 * @Date 2024/12/1 12:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String name;
    private Long number;
    private Long teacherId;
    private String time;
    private String location;
}
