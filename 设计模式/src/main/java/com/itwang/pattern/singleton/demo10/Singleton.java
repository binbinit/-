package com.itwang.pattern.singleton.demo10;

import java.io.Serializable;

/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:52
 * @Description: 测试使用序列化反序列化破坏单例模式解决方案
 */
public class Singleton implements Serializable {

    private Singleton(){};
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }


    // 当进行反序列化时，会自动调用该方法，将该方法的返回值直接返回
    public Object readResolve(){
        return SingletonHolder.INSTANCE;
    }
}
