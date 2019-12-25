package com.zy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

@Data
@TableName(value = "score")
public class Score implements Serializable {
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "sid")
    private Integer sid;

    @TableField(value = "cid")
    private Integer cid;

    @TableField(value = "grade")
    private Double grade;

    private static final long serialVersionUID = 1L;

    public static final String COL_SID = "sid";

    public static final String COL_CID = "cid";

    public static final String COL_GRADE = "grade";
}