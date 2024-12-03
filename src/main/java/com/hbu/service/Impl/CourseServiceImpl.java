package com.hbu.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.hbu.common.context.RedisContext;
import com.hbu.common.result.Result;
import com.hbu.mapper.CourseMapper;
import com.hbu.pojo.dto.CourseDTO;
import com.hbu.pojo.entity.Courses;
import com.hbu.pojo.vo.CourseVO;
import com.hbu.service.CourseService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CourseServiceImpl
 * @Description TODO
 * @Author awei
 * @Date 2024/12/1 12:44
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public Result add(@RequestBody CourseDTO courseDTO) {
        Courses courses = BeanUtil.copyProperties(courseDTO, Courses.class);
        courses.setOriginalNumber(courseDTO.getNumber());
        courseMapper.add(courses);
        stringRedisTemplate.opsForValue().set(RedisContext.COURSE_ID+courses.getId(),
                courses.getOriginalNumber().toString());
        return Result.success();
    }

    @Override
    public Result selectAll() {
       List<CourseVO> courseVOS= courseMapper.selectAll();
       return Result.success(courseVOS);
    }
}
