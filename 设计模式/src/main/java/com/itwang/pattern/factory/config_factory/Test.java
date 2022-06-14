package com.itwang.pattern.factory.config_factory;

/**
 * @Author: ww
 * @DateTime: 2022/4/13 21:15
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("american");
        System.out.println(coffee);
    }
}
