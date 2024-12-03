package com.hbu.mapper;

import com.hbu.pojo.entity.Courses;
import com.hbu.pojo.vo.CourseVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    //实现id回显
    @Options(keyProperty = "id", keyColumn = "id", useGeneratedKeys = true)
    @Insert("insert into edu.courses(name, number, teacher_id, time, location,original_number)" +
            " VALUES (#{name},#{number},#{teacherId},#{time},#{location},#{originalNumber} )")
    void add(Courses courses);
    @Select("select c.*,t.name as teacherName from edu.courses c left join edu.teachers t on t.id = c.teacher_id")
    List<CourseVO> selectAll();
    @Select("select number from edu.courses where id=#{id}")
    Long selectNumber(Long id);
    @Update("update edu.courses set number=number-1 where id =#{id} and number>0")
    void updateCourseNumber(Long id);

    List<Courses> selectByIds(long[] array);
    @Select("select * from edu.courses where teacher_id=#{id}")
    List<Courses> selectByTeacherId(Long id);
}
