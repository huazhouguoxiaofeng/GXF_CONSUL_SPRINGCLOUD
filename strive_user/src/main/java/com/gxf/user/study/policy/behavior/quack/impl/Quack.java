package com.gxf.user.study.policy.behavior.quack.impl;

import com.gxf.user.study.policy.behavior.quack.QuackBehavior;

/**
 * 呱呱叫
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("鸭子呱呱叫");
    }
}
