package com.itwang.pattern.factory.abstract_factory;

/**
 * @Author: ww
 * @DateTime: 2022/4/13 20:49
 * @Description: 美式风味的甜品工厂，可生产美式咖啡和抹茶慕斯
 */
public class AmericanDessertFactory implements DessertFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
