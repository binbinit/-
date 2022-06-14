package com.itwang.pattern.strategy;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:40
 * @Description: 端午(具体策略类)
 */
public class StrategyC implements Strategy{
    public void show() {
        System.out.println("满1000元加一元换购任意200元以下商品");
    }
}
