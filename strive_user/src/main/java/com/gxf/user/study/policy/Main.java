package com.gxf.user.study.policy;

import com.gxf.user.study.policy.behavior.fly.impl.FlyRocketPowered;
import com.gxf.user.study.policy.duck.Duck;
import com.gxf.user.study.policy.duck.ModelDuck;

public class Main {
    public static void main(String[] args) {
        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();
    }
}
