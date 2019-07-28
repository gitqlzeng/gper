package com.gupaoedu.demo.designpatterns.factory;

/**
 * 创建产品的工厂定义，其子工厂需要继承这个工厂模式实现create
 * 生产人类的工厂
 * zengqingliang
 * 2019/6/7 17:43
 */
public class HumanFactory implements IFactory{


    @Override
    public IAnimal create() {
        //返回创建人类
        return (IAnimal) new Human();
    }
}
