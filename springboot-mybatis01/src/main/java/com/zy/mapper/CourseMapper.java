package com.zy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.model.Course;
import com.zy.model.CourseExample;

import java.io.Serializable;
import java.util.List;

import com.zy.vo.CourseScoreVo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    @Override
    @Select("select * from course where id = #{cid} ")
    Course selectById(Serializable id);

    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    List<Course> selectByExample(CourseExample example);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    @Select("select * from course where id = #{cid} ")
    List<Course> selectByCId(int cid);
    @Select("select * from course ")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "id" ,property = "score",one = @One(select = "com.zy.mapper.ScoreMapper.selectByCId"))
    })
    List<CourseScoreVo> selectCourseScore();
    @Select("select * from course ")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "id" ,property = "score",many = @Many(select = "com.zy.mapper.ScoreMapper.selectByCId"))
    })
    List<CourseScoreVo> selectCourseScoreByMany();
}