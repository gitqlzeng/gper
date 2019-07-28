package com.gupaoedu.demo.designpatterns.simpleFactory;

/**
 *
 * 由客户调用工厂生产对应的产品处理对象
 * zengqingliang
 * 2019/6/7 15:56
 */
public class Client {

    public static void main(String[] args){
        //人
        Human animal = (Human) Factory.instance(Human.class);
        if(null!=animal){
            animal.eat();
            animal.sleep();
            animal.thinking();
            animal.exercise();
            animal.speak();
        }


        //鸡
        Chicken animal2 = (Chicken) Factory.instance(Chicken.class);
        if(null!=animal2) {
            animal2.eat();
            animal2.sleep();
            animal2.thinking();
        }
    }

}
