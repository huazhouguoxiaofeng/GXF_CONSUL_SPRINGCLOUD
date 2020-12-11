package com.gxf.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gxf.common.entity.UserEntity;
import com.gxf.user.mapper.UserMapper;
import com.gxf.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity getUserById(long id) {

        LambdaQueryWrapper<UserEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(UserEntity::getId,id);

//        UserEntity user1 = userMapper.selectOne(lqw);

        UserEntity user2 = userMapper.selectById(id);

//        QueryWrapper<UserEntity> qw = new QueryWrapper<>();
//        UserEntity user3 = userMapper.selectOne(qw.eq("id", id));

        // 完全自定义
        String asdfadf = userMapper.findById(String.valueOf(id));
        System.out.println(asdfadf);

		/*
		使用 Wrapper 自定义SQL
		 */
        // 方案一 注解方式 Mapper.java
//        UserEntity user5 = userMapper.findByIdCao(lqw);
        // 方案二 XML形式 Mapper.xml
//		UserEntity user6 = userMapper.findByIdHa(lqw);

        return user2;
    }

    @Override
    public Long add(UserEntity user) {
        long l = System.currentTimeMillis();
        user.setId(l);
        userMapper.insert(user);
        return l;
    }

    @Override
    public void hahahaha() {
        System.out.println("项目启动时调用了自动调用了这个方法AAAAA");
    }
}
