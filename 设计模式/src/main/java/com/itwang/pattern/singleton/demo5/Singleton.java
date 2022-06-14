package com.itwang.pattern.singleton.demo5;

/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:23
 * @Description: 懒汉式(双重检查锁)
 */
public class Singleton {

    // 1、私有构造方法
    private Singleton(){}

    // 2、声明Singleton类型的变量
    // volatile: 解决空指针异常问题
    private static volatile Singleton instance;

    // 3、对外提供公共的访问方式
    public static Singleton getInstance(){
        // 第一次判断，如果instance的值不为null，不许抢占锁，直接返回对象
        if (instance == null){
            synchronized (Singleton.class) {
                // 第二次判断
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
