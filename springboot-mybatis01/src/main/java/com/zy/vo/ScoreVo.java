package com.zy.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zy.model.Course;
import com.zy.model.Score;
import com.zy.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zy
 * @Date 2019-12-24 23:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreVo {
    private Integer id;
    private Integer sid;
    private Integer cid;
    private Course course;
    private Student student;
}
