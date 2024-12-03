package com.hbu.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author awei
 * @Date 2024/11/30 15:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
   private Long id;
   private String name;
   private String department;
}
