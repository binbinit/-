package com.itwang.pattern.decorator;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:49
 * @Description: 装饰者类(抽象装饰者角色)
 */
public abstract class Garnish extends FastFood{

    // 声明快餐类的变量
    private FastFood fastFood;

    public Garnish(float price, String desc, FastFood fastFood) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
