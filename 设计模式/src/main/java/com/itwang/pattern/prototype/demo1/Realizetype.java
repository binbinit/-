package com.itwang.pattern.prototype.demo1;

/**
 * @Author: ww
 * @DateTime: 2022/4/13 21:26
 * @Description: 具体原型类
 */
public class Realizetype implements Cloneable{
    public Realizetype() {
        System.out.println("具体的原型对象被创建完成");
    }

    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功");
        return (Realizetype)super.clone();
    }
}
