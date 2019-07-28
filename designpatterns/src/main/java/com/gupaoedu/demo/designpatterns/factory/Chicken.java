package com.gupaoedu.demo.designpatterns.factory;


import com.gupaoedu.demo.designpatterns.factory.IAnimal;

/**
 *
 * 小鸡
 * zengqingliang
 * 2019/6/7 15:47
 */
public class Chicken implements IAnimal {
    @Override
    public void eat() {
        System.out.println("小鸡啄米");
    }

    @Override
    public void sleep() {
        System.out.println("小鸡睡觉");
    }

    @Override
    public void thinking() {
        System.out.println("抱歉！小鸡无法思考");
    }
}
