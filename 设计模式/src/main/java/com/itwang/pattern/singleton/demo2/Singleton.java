package com.itwang.pattern.singleton.demo2;

/**
 * @Author: ww
 * @DateTime: 2022/4/10 23:21
 * @Description: 饿汉式(静态代码块)
 */
public class Singleton {

    // 1.私有构造方法
    private Singleton(){}

    // 2.声明Singleton类型的变量
    private static Singleton instance;  //null

    // 3.在静态代码块中进行赋值
    static {
        instance = new Singleton();
    }

    // 4.对外提供获取该类对象的方法
    public static Singleton getInstance(){
        return instance;
    }
}
