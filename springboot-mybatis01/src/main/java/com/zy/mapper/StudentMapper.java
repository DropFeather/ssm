package com.zy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.model.Student;
import com.zy.model.StudentExample;

import java.io.Serializable;
import java.util.List;

import com.zy.vo.ScoreVo;
import com.zy.vo.StudentCourseVo;
import com.zy.vo.StudentScoreVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Override
    @Select("select * from student where id = #{id} ")
    Student selectById(Serializable id);

    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    List<Student> selectByExample(StudentExample example);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);
    @Select("select * from student where id = #{id} ")
    Student selectByStuId(int id);

    @Select("select * from student inner join score on student.id=score.sid")
    @Results({
           @Result(column = "cid",property = "course", many = @Many(select = "com.zy.mapper.CourseMapper.selectById",fetchType = FetchType.LAZY))
    })
    List<StudentCourseVo> selectScoreToStudentAndCourse();

    @Select("select * from student where id = #{id}")
    @Results({
            @Result(column = "id",property = "score", one = @One(select = "com.zy.mapper.ScoreMapper.selectBySId",fetchType = FetchType.LAZY))
    })
    public List<StudentScoreVo> selectStudentScoreById(int id);
}