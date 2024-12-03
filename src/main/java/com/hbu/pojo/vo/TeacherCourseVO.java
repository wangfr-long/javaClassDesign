package com.hbu.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName TeacherCourseVO
 * @Description TODO
 * @Author awei
 * @Date 2024/12/2 13:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherCourseVO {
    private Long id;
    private String name;
    private Long studentNumber;
    private String time;
    private String location;

}
