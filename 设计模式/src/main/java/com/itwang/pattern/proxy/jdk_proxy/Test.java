package com.itwang.pattern.proxy.jdk_proxy;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 17:58
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        // 获取代理对象
        // 1.创建代理工厂对象
        ProxyFactory factory = new ProxyFactory();
        // 2.使用factory对象的方法获取代理对象
        SellTickets proxyObject = factory.getProxyObject();
        proxyObject.sell();
        System.out.println(proxyObject.getClass());
        // 让程序一直执行 以方便看到动态生成的代理对象
        while (true){

        }
    }
}
