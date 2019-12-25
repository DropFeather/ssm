package com.zy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.model.Score;
import com.zy.model.ScoreExample;

import java.io.Serializable;
import java.util.List;

import com.zy.vo.ScoreVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

@Mapper
public interface ScoreMapper extends BaseMapper<Score> {

    @Select("select * from score where cid=#{id}")
    List<Score> selectByCId(int id);

    @Select("select * from score where sid=#{id}")
    Score selectBySId(int id);
    long countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    List<Score> selectByExample(ScoreExample example);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);


    @Select("select * from score")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "sid",property = "sid"),
            @Result(column = "cid",property = "cid"),
            @Result(column = "sid",property = "student" ,one=@One(select = "com.zy.mapper.StudentMapper.selectById",fetchType = FetchType.LAZY)),
            @Result(column = "cid",property = "course", one= @One(select = "com.zy.mapper.CourseMapper.selectById",fetchType = FetchType.LAZY))
              })
    List<ScoreVo> selectScoreToStudentAndCourse();
}