package com.hbu.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName TeacherVO
 * @Description TODO
 * @Author awei
 * @Date 2024/12/2 10:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherVO {
    private Long id;
    private String name;
    private String department;
    private String className;

}
