package com.itwang.pattern.factory.factory_method;

/**
 * @Author: ww
 * @DateTime: 2022/4/12 20:35
 * @Description: 抽象工厂
 */
public interface CoffeeFactory {
    // 创建咖啡对象的方法
    Coffee createCoffee();
}
