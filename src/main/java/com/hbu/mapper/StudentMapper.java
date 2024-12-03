package com.hbu.mapper;

import com.hbu.pojo.dto.StudentDTO;
import com.hbu.pojo.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {
    @Insert("insert into edu.students(name, age,student_id) VALUES (#{name},#{age},#{studentId})")
    void add(Student student);
    @Select("select * from edu.students where student_id=#{studentId}")
    Student selectById(String studentId);

    void update(StudentDTO studentDTO);
    @Update("update edu.students set class_id=#{classId} where student_id=#{studentId}")
    void CourseSelect(String classId, String studentId);
}
