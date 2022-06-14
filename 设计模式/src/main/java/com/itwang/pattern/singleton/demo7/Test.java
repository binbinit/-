package com.itwang.pattern.singleton.demo7;

/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:45
 * @Description: 测试饿汉式枚举方式
 */
public class Test {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;

        System.out.println(instance1 == instance2);
    }
}
