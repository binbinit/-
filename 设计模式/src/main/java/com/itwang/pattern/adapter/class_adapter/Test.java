package com.itwang.pattern.adapter.class_adapter;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:07
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        // 创建计算机对象
        Computer computer = new Computer();
        // 读取SD卡中的数据
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        System.out.println("========================");

        // 使用该计算机读取TF卡中数据
        // 定义适配器类
        String msg1 = computer.readSD(new SDAdapterTF());
        System.out.println(msg1);
    }
}
