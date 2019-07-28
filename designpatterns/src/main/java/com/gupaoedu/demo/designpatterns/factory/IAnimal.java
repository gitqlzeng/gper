package com.gupaoedu.demo.designpatterns.factory;

/**
 * 动物
 * 比如：
 *      鸡：公鸡、母鸡
 *      人：男人、女人
 * zengqingliang
 * 2019/6/7 17:44
 */
public interface IAnimal {

    //吃
    public void eat();

    //睡觉
    public void sleep();

    //思考
    public void thinking();

}
