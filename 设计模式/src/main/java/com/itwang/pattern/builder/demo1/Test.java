package com.itwang.pattern.builder.demo1;

/**
 * @Author: ww
 * @DateTime: 2022/4/14 19:36
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        // 创建指挥者对象
        Director director = new Director(new MobileBuilder());
        // 组装自行车
        Bike bike = director.construct();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}
