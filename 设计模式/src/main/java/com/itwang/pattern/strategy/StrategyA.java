package com.itwang.pattern.strategy;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:39
 * @Description: 春节(具体策略类)
 */
public class StrategyA implements Strategy{
    public void show() {
        System.out.println("买一送一");
    }
}
