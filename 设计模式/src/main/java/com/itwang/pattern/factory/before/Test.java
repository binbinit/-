package com.itwang.pattern.factory.before;

/**
 * @Author: ww
 * @DateTime: 2022/4/12 19:30
 * @Description: Test
 */
public class Test {
    public static void main(String[] args) {
        // 1.创建咖啡店类
        CoffeeStore coffeeStore = new CoffeeStore();
        // 2.点咖啡
        Coffee coffee = coffeeStore.orderCoffee("latte");

        System.out.println(coffee.getName());
    }
}
