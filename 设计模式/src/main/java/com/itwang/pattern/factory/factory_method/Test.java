package com.itwang.pattern.factory.factory_method;

/**
 * @Author: ww
 * @DateTime: 2022/4/12 20:40
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        // 创建咖啡店对象
        CoffeeStore coffeeStore = new CoffeeStore();
        // 创建工厂对象
        CoffeeFactory factory = new AmericanCoffeeFactory();
        coffeeStore.setFactory(factory);

        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());

    }
}
