package com.hbu.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CourseVO
 * @Description TODO
 * @Author awei
 * @Date 2024/12/2 10:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseVO {
    private Long id;
    private String name;
    private Long number;
    private String teacherName;
    private String time;
    private String location;
}
