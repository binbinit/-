package com.itwang.pattern.singleton.demo3;

/**
 * @Author: ww
 * @DateTime: 2022/4/10 23:36
 * @Description: 测试懒汉式(线程不安全方式)
 */
public class Test {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2);
    }
}
