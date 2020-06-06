package com.gxf.user.study.policy.duck;

import com.gxf.user.study.policy.behavior.fly.impl.FlyNoWay;
import com.gxf.user.study.policy.behavior.fly.impl.FlyRocketPowered;
import com.gxf.user.study.policy.behavior.fly.impl.FlyWithWings;
import com.gxf.user.study.policy.behavior.quack.impl.Quack;

/**
 * 模型鸭子:
 * 呱呱叫
 * 用翅膀飞
 */
public class ModelDuck extends Duck{

    public ModelDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("模型鸭子");
    }

}
