package com.itwang.pattern.proxy.static_proxy;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 17:37
 * @Description: 代理类
 */
public class ProxyPoint implements SellTickets{

    private TrainStation trainStation = new TrainStation();
    @Override
    public void sell() {
        System.out.println("代理类卖票");
        trainStation.sell();
    }
}
