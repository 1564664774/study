package com.zqh;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zqh.mapper.CourseMapper;
import com.zqh.pojo.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2021/1/4 15:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void addCourse() {
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setCname("java");
            course.setUserId(100L);
            course.setCstatus("1");
            courseMapper.insert(course);
        }
    }

    @Test
    public void findCourse() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", 552951930976993280L);
        Course course = courseMapper.selectOne(wrapper);
        System.out.println(course);
    }
}
