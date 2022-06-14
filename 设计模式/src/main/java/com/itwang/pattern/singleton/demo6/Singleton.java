package com.itwang.pattern.singleton.demo6;

/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:36
 * @Description: 懒汉式(静态内部类)
 */
public class Singleton {

    // 1.私有构造方法
    private Singleton(){

    }

    // 2.定义一个静态内部类
    private static class SingletonHolder{
        // 在内部类中声明并初始化外部类对象
        private static final Singleton INSTANCE = new Singleton();
    }

    // 3.提供公共的访问方式
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
