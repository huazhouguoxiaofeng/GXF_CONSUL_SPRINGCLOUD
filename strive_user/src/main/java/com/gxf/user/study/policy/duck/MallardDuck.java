package com.gxf.user.study.policy.duck;

import com.gxf.user.study.policy.behavior.fly.impl.FlyWithWings;
import com.gxf.user.study.policy.behavior.quack.impl.Quack;

/**
 * 绿头鸭:
 * 呱呱叫
 * 用翅膀飞
 */
public class MallardDuck extends Duck{

    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("外观是绿头");
    }

}
