package com.itwang.pattern.singleton.demo9;

import com.itwang.pattern.singleton.demo9.Singleton;

import java.lang.reflect.Constructor;

/**
 * @Author: ww
 * @DateTime: 2022/4/11 18:08
 * @Description: 测试使用反射破坏单例模式
 */
public class Test {
    public static void main(String[] args) throws Exception {
        // 1.获取Singleton的字节码对象
        Class<Singleton> singletonClass = Singleton.class;
        // 2.获取无参构造方法对象
        Constructor<Singleton> declaredConstructor = singletonClass.getDeclaredConstructor();
        // 3.取消访问检查
        declaredConstructor.setAccessible(true);
        // 4.使用反射方式创建Singleton对象
        Singleton instance1 = declaredConstructor.newInstance();
        Singleton instance2 = declaredConstructor.newInstance();


        //true: 没有破坏了单例模式， false: 破坏了
        System.out.println(instance1 == instance2);
    }
}
