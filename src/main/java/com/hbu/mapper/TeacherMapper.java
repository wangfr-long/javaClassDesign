package com.hbu.mapper;

import com.hbu.pojo.dto.TeacherDTO;
import com.hbu.pojo.entity.Teacher;
import com.hbu.pojo.vo.TeacherVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Insert("insert into edu.teachers(name, department) VALUES (#{name},#{department})")
    void add(Teacher teacher);

    List<TeacherVO> select(TeacherDTO teacherDTO);

    void update(TeacherDTO teacherDTO);
}
