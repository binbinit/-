package com.itwang.pattern.factory.abstract_factory;

/**
 * @Author: ww
 * @DateTime: 2022/4/13 20:52
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        ItalyDessertFactory factory = new ItalyDessertFactory();
        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();

        System.out.println(coffee.getName());
        dessert.show();
    }
}
