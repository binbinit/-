package com.itwang.pattern.factory.factory_method;

/**
 * @Author: ww
 * @DateTime: 2022/4/12 20:34
 * @Description: 咖啡店类
 */
public class CoffeeStore {

    private CoffeeFactory factory;
    public void setFactory(CoffeeFactory factory){
        this.factory = factory;
    }

    // 点咖啡
    public Coffee orderCoffee(){
        Coffee coffee = factory.createCoffee();
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
