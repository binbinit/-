package com.itwang.pattern.factory.factory_method;

/**
 * @Author: ww
 * @DateTime: 2022/4/12 20:36
 * @Description: 美式咖啡工厂对象，专门用来生产咖啡
 */
public class AmericanCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
