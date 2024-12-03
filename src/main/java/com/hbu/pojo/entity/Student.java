package com.hbu.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName Student
 * @Description TODO
 * @Author awei
 * @Date 2024/11/30 15:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String studentId;
    private int age;
    private String classId;
}
