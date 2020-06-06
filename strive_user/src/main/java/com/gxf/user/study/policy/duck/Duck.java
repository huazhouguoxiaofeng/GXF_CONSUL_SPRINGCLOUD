package com.gxf.user.study.policy.duck;

import com.gxf.user.study.policy.behavior.quack.QuackBehavior;
import com.gxf.user.study.policy.behavior.fly.FlyBehavior;
import lombok.Data;

@Data
public abstract class Duck {

    /**
     * 同一个package里面都实现这属性
     */
    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    /**
     * 外观：各个鸭子有各有他们的外观嘛
     */
    public abstract void display();

    /**
     * 游泳:所有的鸭子都会游泳哦
     */
    public void swim(){
        System.out.println("所有的鸭子都会游泳哦");
    }

    /**
     * 叫: 委托给行为类
     */
    public void performQuack(){
        quackBehavior.quack();
    }

    /**
     * 飞:委托给行为类
     */
    public void performFly(){
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }



}
