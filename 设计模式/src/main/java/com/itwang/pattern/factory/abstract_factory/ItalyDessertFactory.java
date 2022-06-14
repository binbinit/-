package com.itwang.pattern.factory.abstract_factory;

/**
 * @Author: ww
 * @DateTime: 2022/4/13 20:51
 * @Description: 意大利风味
 */
public class ItalyDessertFactory implements DessertFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Trimisu();
    }
}
