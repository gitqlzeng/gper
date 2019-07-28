package com.gupaoedu.demo.designpatterns.factory;

/**
 * zengqingliang
 * 2019/6/7 18:24
 */
public class Client {

    public static void main(String[] args) {
        //通过工厂创建对象
        IFactory factory = new ChickenFactory();
        IAnimal animal = factory.create();

        animal.eat();
        animal.sleep();
        animal.thinking();


    }
}
