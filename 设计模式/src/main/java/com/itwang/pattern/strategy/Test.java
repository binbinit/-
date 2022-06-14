package com.itwang.pattern.strategy;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:44
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        SalesMan salesMan = new SalesMan(new StrategyA());
        salesMan.salesManShow();
    }
}
