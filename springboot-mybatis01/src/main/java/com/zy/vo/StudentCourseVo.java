package com.zy.vo;

import com.zy.model.Course;
import com.zy.model.Score;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zy
 * @Date 2019-12-25 15:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseVo {
    private Integer id;
    private String name;
    private Integer age;
    private List<Course> course;
}
