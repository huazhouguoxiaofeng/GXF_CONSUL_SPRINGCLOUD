package com.gxf.user;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * mybatis 自动填充物理删除的一个很重要的功能
 * 1、com.gxf.common.entity.BaseEntity
 * 2、这个
 * 3、配置文件:
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入操作：自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 填充时间
        Object createTime = getFieldValByName("createTime", metaObject);
        if(createTime == null){
            setFieldValByName("createTime", LocalDateTime.now(),metaObject);
        }
        // 填充逻辑删除
        setFieldValByName("deleteFlag",0, metaObject);
        // 更新时间也要搞上去
        setFieldValByName("updateTime",LocalDateTime.now(), metaObject);

    }

    /**
     * 更新操作：自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 获取到需要被填充的字段值
        setFieldValByName("updateTime",LocalDateTime.now(),metaObject);
    }
}
