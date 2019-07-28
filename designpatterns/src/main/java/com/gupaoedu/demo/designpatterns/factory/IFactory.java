package com.gupaoedu.demo.designpatterns.factory;

/**
 * 创建产品的工厂定义，其子工厂需要继承这个工厂模式实现create
 * zengqingliang
 * 2019/6/7 17:43
 */
public interface IFactory {

    IAnimal create();

}
