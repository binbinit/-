package com.itwang.pattern.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 18:36
 * @Description: 代理对象工厂，用来获取代理对象
 */
public class ProxyFactory implements MethodInterceptor {
    //声明火车站对象
    private TrainStation station = new TrainStation();

    public TrainStation getProxyObject(){
        // 创建Enhancer对象，类似jdk代理中的Proxy类
        Enhancer enhancer = new Enhancer();
        // 设置父类的字节码对象
        enhancer.setSuperclass(TrainStation.class);
        // 设置回调函数 会去自动调用intercept方法
        enhancer.setCallback(this);
        // 创建代理对象
        TrainStation proxyObject = (TrainStation) enhancer.create();

        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // System.out.println("该方法执行了");
        System.out.println("增强了该方法");
        // 要调用目标对象的方法
        TrainStation obj = (TrainStation) method.invoke(station,objects);
        return obj;
    }
}
