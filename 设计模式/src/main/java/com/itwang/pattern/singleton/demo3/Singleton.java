package com.itwang.pattern.singleton.demo3;

/**
 * @Author: ww
 * @DateTime: 2022/4/10 23:31
 * @Description: 懒汉式(线程不安全方式)
 */
public class Singleton {

    // 1.私有构造方法
    private Singleton(){}

    // 2.声明Singleton类型的变量instance
    private static Singleton instance;

    // 3.对外提供访问方式
    public static Singleton getInstance(){
        if (instance == null){
            // 线程1等待，线程2获取到cpu执行权，也会进入判断里面，会导致变成多例
            instance = new Singleton();
        }
        return instance;
    }
}
