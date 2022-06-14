package com.itwang.pattern.singleton.demo5;

/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:28
 * @Description: 测试懒汉式双重检查锁
 */
public class Test {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2);
    }
}
