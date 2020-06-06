package com.gxf.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class BaseEntity {

    /**
     * 逻辑删除的字段
     * @JsonProperty  这样的话，就不返回 deleteFlag ，返回指定值 了
     * @TableLogic  逻辑删除，application.yml 有配置
     */
    @TableLogic
    @TableField(value = "delete_flag",fill = FieldFill.INSERT)
    private Integer deleteFlag;

    /**
     * LocalDate 只能返回日期  LocalDate.now()
     * LocalTime 只能返回时间   LocalTime.now()
     * LocalDateTime 返回时间和日期  LocalDateTime.now()
     * Date 好像既返回日期也返回时间，但是格式不怎么友好
     * @JsonFormat 加了这个注解之后就变得很友好了，好像前端也要以这样的格式传过来
     *
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
    @ApiModelProperty(hidden = true)
    private LocalDateTime createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(hidden = true)
    private LocalDateTime updateTime;

}
