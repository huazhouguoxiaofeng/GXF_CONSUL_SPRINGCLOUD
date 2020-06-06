package com.gxf.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class UserEntity extends BaseEntity{

    /**
     * 主键
     */
    @TableId(value = "id")
    @ApiModelProperty(hidden = true)
    private long id;

    @TableField(value = "name")
    @ApiModelProperty(name = "姓名",example = "guoxiaofeng")
    private String name;
//	private transient String name;

    @TableField(value = "phone")
    @ApiModelProperty(name = "电话",example = "15994814151")
    private String phone;

    @TableField(value = "age")
    @ApiModelProperty(name = "年龄",example = "30")
    private int age;

    /**
     * @TableField 是否为数据库表字段，默认true
     * @JsonIgnore JSON格式这个字段就不返回前端了
     */
    @TableField(exist = false)
    private String columnOne;


}
