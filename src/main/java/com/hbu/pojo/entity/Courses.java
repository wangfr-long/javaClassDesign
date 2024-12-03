package com.hbu.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Courses
 * @Description TODO
 * @Author awei
 * @Date 2024/11/30 15:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courses {
    private Long id;
    private String name;
    private Long number;
    private Long teacherId;
    private String time;
    private String location;
    private Long originalNumber;
}
