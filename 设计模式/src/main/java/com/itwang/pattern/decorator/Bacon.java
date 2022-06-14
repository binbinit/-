package com.itwang.pattern.decorator;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:52
 * @Description: 培根类(具体装饰者角色)
 */
public class Bacon extends Garnish{
    public Bacon(FastFood fastFood) {
        super(2, "培根", fastFood);
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
