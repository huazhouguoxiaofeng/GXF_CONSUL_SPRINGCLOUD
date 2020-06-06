package com.gxf.user.study.policy.behavior.quack.impl;

import com.gxf.user.study.policy.behavior.quack.QuackBehavior;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("橡皮鸭子吱吱叫");
    }
}
