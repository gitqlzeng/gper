package com.gupaoedu.demo.designpatterns.simpleFactory;

/**
 *
 * 人类
 * zengqingliang
 * 2019/6/7 15:50
 */
public class Human implements IAnimal {

    @Override
    public void eat() {
        System.out.println("人吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("人睡觉");
    }

    @Override
    public void thinking() {
        System.out.println("人在思考问题");
    }

    public void exercise() {
        System.out.println("人在锻炼身体");
    }

    public void speak() {
        System.out.println("人在说话");
    }


}
