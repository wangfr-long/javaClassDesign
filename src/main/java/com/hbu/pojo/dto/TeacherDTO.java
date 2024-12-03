package com.hbu.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName TeacherDTO
 * @Description TODO
 * @Author awei
 * @Date 2024/12/1 10:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {
    private Long id;
    private String name;
    private String department;
}
