package com.itwang.pattern.singleton.demo1;

/**
 * @Author: ww
 * @DateTime: 2022/4/10 23:12
 * @Description: 测试饿汉式(静态成员变量)
 */
public class Test {
    public static void main(String[] args) {
        // 创建Singleton类的对象
        Singleton singleton1 = Singleton.getInstance();

        Singleton singleton2 = Singleton.getInstance();

        // 判断获取到的两个对象是否是同一个 true
        System.out.println(singleton1 == singleton2);
    }
}
