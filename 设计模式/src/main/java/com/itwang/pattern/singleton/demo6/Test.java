package com.itwang.pattern.singleton.demo6;

/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:40
 * @Description: 测试懒汉式静态内部类
 */
public class Test {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2);
    }
}
