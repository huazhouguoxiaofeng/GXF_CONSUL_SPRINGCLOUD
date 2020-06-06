package com.gxf.user.service;

import com.gxf.common.entity.UserEntity;

public interface UserService {
    UserEntity getUserById(long id);

    Long add(UserEntity user);

    void hahahaha();
}
