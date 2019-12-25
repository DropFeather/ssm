package com.zy.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zy.model.Score;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zy
 * @Date 2019-12-25 16:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseScoreVo {
    private Integer id;
    private String name;
    private List<Score> score;
}
