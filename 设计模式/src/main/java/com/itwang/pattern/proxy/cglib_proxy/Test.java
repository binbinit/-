package com.itwang.pattern.proxy.cglib_proxy;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 18:41
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        // 创建代理工厂对象
        ProxyFactory factory = new ProxyFactory();
        // 获取代理对象
        TrainStation proxyObject = factory.getProxyObject();
        proxyObject.sell();
    }
}
