package com.itwang.pattern.factory.simple_factory;

/**
 * @Author: ww
 * @DateTime: 2022/4/12 20:01
 * @Description: 简单咖啡工厂
 */
public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type){
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)){
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("没有该咖啡");
        }
        return coffee;
    }
}
