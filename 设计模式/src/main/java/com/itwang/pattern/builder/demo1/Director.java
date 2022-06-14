package com.itwang.pattern.builder.demo1;

/**
 * @Author: ww
 * @DateTime: 2022/4/14 19:34
 * @Description: 指挥者
 */
public class Director {
    // 声明Builder类型的变量
    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    // 组装自行车
    public Bike construct(){
        builder.builderFrame();
        builder.builderSeat();
        return builder.createBike();
    }
}

