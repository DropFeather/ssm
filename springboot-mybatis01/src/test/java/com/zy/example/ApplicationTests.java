package com.zy.example;

import com.zy.mapper.CourseMapper;
import com.zy.mapper.ScoreMapper;
import com.zy.mapper.StudentMapper;
import com.zy.model.CourseExample;
import com.zy.model.Score;
import com.zy.model.Student;
import com.zy.vo.CourseScoreVo;
import com.zy.vo.ScoreVo;
import com.zy.vo.StudentCourseVo;
import com.zy.vo.StudentScoreVo;
import org.apache.ibatis.executor.statement.StatementUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.zip.CheckedOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.zy.mapper")
public class ApplicationTests {
@Autowired
private ScoreMapper mapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Test
    public void contextLoads() {
        List<ScoreVo> scoreVos = mapper.selectScoreToStudentAndCourse();
        System.out.println(scoreVos);
    }
    @Test
    public void contextLoads1() {
        List<StudentCourseVo> scoreVos = studentMapper.selectScoreToStudentAndCourse();
        System.out.println(scoreVos);
        for (StudentCourseVo scoreVo : scoreVos) {
            System.out.println(scoreVo);
        }
    }
    @Test
    public void contextLoads2() {
        List<CourseScoreVo> courseScoreVos = courseMapper.selectCourseScore();
        for (CourseScoreVo courseScoreVo : courseScoreVos) {
            System.out.println(courseScoreVo);
        }

    }
    @Test
    public void contextLoads3() {
        List<CourseScoreVo> courseScoreVos = courseMapper.selectCourseScoreByMany();
        for (CourseScoreVo courseScoreVo : courseScoreVos) {
            System.out.println(courseScoreVo);
        }

    }
    @Test
    public void contextLoads4() {
        List<StudentScoreVo> list = studentMapper.selectStudentScoreById(1);
        for (StudentScoreVo studentScoreVo : list) {
            System.out.println(studentScoreVo);
        }

    }
}
