package com.hbu.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName StudentVO
 * @Description TODO
 * @Author awei
 * @Date 2024/11/30 17:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentVO {
    private Long id;
    private String studentId;
    private String name;
    private int age;
    private String [] classes;
}
