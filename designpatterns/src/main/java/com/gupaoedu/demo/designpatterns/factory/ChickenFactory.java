package com.gupaoedu.demo.designpatterns.factory;

/**
 * 生产小鸡的工厂
 * zengqingliang
 * 2019/6/7 18:14
 */
public class ChickenFactory implements IFactory {

    @Override
    public IAnimal create() {
        //返回创建小鸡
        return (IAnimal)new Chicken();
    }
}
