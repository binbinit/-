package com.itwang.pattern.singleton.demo8;

import java.io.Serializable;

/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:52
 * @Description: 测试使用序列化反序列化破坏单例模式
 */
public class Singleton implements Serializable {

    private Singleton(){};
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
