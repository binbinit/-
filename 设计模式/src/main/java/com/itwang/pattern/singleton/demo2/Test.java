package com.itwang.pattern.singleton.demo2;

/**
 * @Author: ww
 * @DateTime: 2022/4/10 23:24
 * @Description: 测试饿汉式(静态代码块)
 */
public class Test {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2);
    }
}
