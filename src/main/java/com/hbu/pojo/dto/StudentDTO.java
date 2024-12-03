package com.hbu.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName StudentDTO
 * @Description TODO
 * @Author awei
 * @Date 2024/11/30 16:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String studentId;
    private String name;
    private int age;
}
