package com.gxf.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxf.common.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserEntity> {

    String findById(String appId);
}