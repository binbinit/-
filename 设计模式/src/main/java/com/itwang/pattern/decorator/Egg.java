package com.itwang.pattern.decorator;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:52
 * @Description: 鸡蛋类(具体装饰者角色)
 */
public class Egg extends Garnish{
    public Egg(FastFood fastFood) {
        super(1, "鸡蛋", fastFood);
    }

    @Override
    public float cost() {
        // 计算价格
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
