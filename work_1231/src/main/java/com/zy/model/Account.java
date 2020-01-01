package com.zy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com.zy.model.Account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "account")
public class Account implements Serializable {
     @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="null")
    private Integer id;

    @TableField(value = "name")
    @ApiModelProperty(value="null")
    private String name;

    @TableField(value = "tel")
    @ApiModelProperty(value="null")
    private String tel;

    @TableField(value = "email")
    @ApiModelProperty(value="null")
    private String email;

    @TableField(value = "address")
    @ApiModelProperty(value="null")
    private String address;

    @TableField(value = "reTime")
    @JsonFormat(pattern = "YYYY-MM-dd")
    @ApiModelProperty(value="null")
    private Date retime;

    private static final long serialVersionUID = 1L;

    public static final String COL_NAME = "name";

    public static final String COL_TEL = "tel";

    public static final String COL_EMAIL = "email";

    public static final String COL_ADDRESS = "address";

    public static final String COL_RETIME = "reTime";
}