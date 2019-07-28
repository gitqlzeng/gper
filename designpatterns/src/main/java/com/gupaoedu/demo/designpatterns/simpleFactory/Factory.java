package com.gupaoedu.demo.designpatterns.simpleFactory;

/**
 * 父工厂，创建其他实现类
 * zengqingliang
 * 2019/6/7 15:42
 */
public class Factory {

    //工厂根据需求创建具体产品
    public static Object instance(Class<? extends IAnimal> animalClazz) {
        //Animal animal = null;
        /*if("Human".equals(animalType)){
            animal = new Human();
        }
        if("Chicken".equals(animalType)){
            animal = new Chicken();
        }*/

        if(null!=animalClazz){
            try {
                return animalClazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;

    }


}
