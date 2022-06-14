package com.itwang.pattern.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 17:49
 * @Description: 获取代理对象的工厂类 代理类也实现了对应的接口
 */
public class ProxyFactory {

    // 声明目标对象
    private TrainStation trainStation = new TrainStation();

    // 获取代理对象的方法
    public SellTickets getProxyObject(){
        // 返回代理对象
        /*
        * ClassLoader loader: 类加载器，用于加载代理类，可以通过目标对象获取类加载器
        * Class<?>[] interfaces： 代理类实现的接口的字节码对象
        * InvocationHandler h： 代理对象的调用处理程序
        * */
        SellTickets proxyObject = (SellTickets)Proxy.newProxyInstance(trainStation.getClass().getClassLoader(), trainStation.getClass().getInterfaces(),
                new InvocationHandler() {
                    /*
                    * invoke: 进行业务逻辑处理
                    * Object proxy: 代理对象，和proxyObject对象是同一个对象，在invoke方法中基本不用
                    * Method method：对接口中的方法进行封装的method对象
                    * Object[] args: 调用方法的实际参数
                    * 返回值：方法的返回值
                    * */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // System.out.println("invoke方法执行了");
                        System.out.println("jdk动态代理增强");
                        // 执行目标对象的方法
                        Object obj = method.invoke(trainStation, args);
                        return obj;
                    }
                });
        return proxyObject;
    }
}
