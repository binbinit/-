package com.itwang.pattern.factory.simple_factory;

/**
 * @Author: ww
 * @DateTime: 2022/4/12 20:07
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        Coffee c = store.orderCoffee("latte");
        System.out.println(c.getName());
    }
}
