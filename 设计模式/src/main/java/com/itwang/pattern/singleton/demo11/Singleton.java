package com.itwang.pattern.singleton.demo11;

import java.io.Serializable;

/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:52
 * @Description: 测试使用反射破坏单例模式解决方案
 */
public class Singleton implements Serializable {

    private static boolean flag = false;
    private Singleton(){
        synchronized (Singleton.class){
            // 判断flag的值是否是true，如果是true，说明非第一次访问，直接抛一个异常，如果是false的话，说明第一次访问
            if (flag){
                throw new RuntimeException("不能创建多个对象");
            }
            // 将flag的值设置为true
            flag = true;
        }
    };
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
