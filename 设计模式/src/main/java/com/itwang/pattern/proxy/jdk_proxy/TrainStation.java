package com.itwang.pattern.proxy.jdk_proxy;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 17:36
 * @Description: 火车站类(具体主题类)
 */
public class TrainStation implements SellTickets {
    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
