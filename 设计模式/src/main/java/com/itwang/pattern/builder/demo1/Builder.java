package com.itwang.pattern.builder.demo1;

/**
 * @Author: ww
 * @DateTime: 2022/4/14 19:28
 * @Description: 抽象构造类
 */
public abstract class Builder {

    // 声明Bike类型变量并赋值
    protected Bike bike = new Bike();

    public abstract void builderFrame();

    public abstract void builderSeat();

    public abstract Bike createBike();
}
