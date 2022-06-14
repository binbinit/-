package com.itwang.pattern.strategy;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:39
 * @Description: 中秋节(具体策略类)
 */
public class StrategyB implements Strategy{
    public void show() {
        System.out.println("满200元减50元");
    }
}
