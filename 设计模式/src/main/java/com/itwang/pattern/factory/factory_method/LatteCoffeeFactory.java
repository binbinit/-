package com.itwang.pattern.factory.factory_method;

/**
 * @Author: ww
 * @DateTime: 2022/4/12 20:37
 * @Description: 拿铁咖啡工厂
 */
public class LatteCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
