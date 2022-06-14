package com.itwang.pattern.adapter.object_adapter;

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

        SDAdapterTF sdAdapterTF = new SDAdapterTF(new TFCardImpl());
        // 使用该电脑读取TF卡中的数据
        String msg1 = computer.readSD(sdAdapterTF);
        System.out.println(msg1);
    }
}
