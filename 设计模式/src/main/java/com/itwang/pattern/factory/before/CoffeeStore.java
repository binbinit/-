package com.itwang.pattern.factory.before;

/**
 * @Author: ww
 * @DateTime: 2022/4/12 19:26
 * @Description: 咖啡店
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type){
        // 声明Coffee类型的变量，根据不同类型创建不同的coffee子类对象
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)){
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("没有该咖啡");
        }
        // 加糖加奶
        coffee.addMilk();
        coffee.addSugar();

        return coffee;

    }
}
