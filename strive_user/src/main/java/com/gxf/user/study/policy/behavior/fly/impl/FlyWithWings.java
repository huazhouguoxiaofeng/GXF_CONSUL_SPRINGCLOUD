package com.gxf.user.study.policy.behavior.fly.impl;

import com.gxf.user.study.policy.behavior.fly.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("实现鸭子飞行");
    }

}
