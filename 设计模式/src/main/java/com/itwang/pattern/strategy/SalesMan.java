package com.itwang.pattern.strategy;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:43
 * @Description: 促销员(环境类)，用于连接上下文
 */
public class SalesMan {

    // 聚合策略类对象
    private Strategy strategy;

    public SalesMan(Strategy strategy) {
        this.strategy = strategy;
    }

    //向客户展示促销活动
    public void salesManShow(){
        strategy.show();
    }
}
