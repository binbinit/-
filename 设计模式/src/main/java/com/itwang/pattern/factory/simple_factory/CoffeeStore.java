package com.itwang.pattern.factory.simple_factory;

/**
 * @Author: ww
 * @DateTime: 2022/4/12 19:50
 * @Description: TODO
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type){
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.createCoffee(type);
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
