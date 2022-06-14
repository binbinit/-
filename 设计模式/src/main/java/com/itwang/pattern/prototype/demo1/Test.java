package com.itwang.pattern.prototype.demo1;

/**
 * @Author: ww
 * @DateTime: 2022/4/13 21:28
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 创建一个原型类对象
        Realizetype realizetype = new Realizetype();

        // 调用Realizetype类中的clone方法进行克隆
        Realizetype clone = realizetype.clone();

        System.out.println("原型对象和克隆出的对象是否是同一个对象？");
        System.out.println(realizetype == clone);
    }
}
