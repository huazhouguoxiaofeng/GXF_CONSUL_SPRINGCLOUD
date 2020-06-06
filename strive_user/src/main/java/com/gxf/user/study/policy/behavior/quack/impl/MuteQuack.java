package com.gxf.user.study.policy.behavior.quack.impl;

import com.gxf.user.study.policy.behavior.quack.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("什么都不做，不会叫");
    }
}
