package com.itwang.pattern.factory.abstract_factory;

/**
 * @Author: ww
 * @DateTime: 2022/4/13 20:48
 * @Description: 抽象工厂
 */
public interface DessertFactory {

    // 生产咖啡的功能
    Coffee createCoffee();

    // 生产甜品的功能
    Dessert createDessert();

}
