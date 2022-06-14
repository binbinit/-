package com.itwang.pattern.builder.demo2;

/**
 * @Author: ww
 * @DateTime: 2022/4/14 19:54
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .mainboard("华硕")
                .memory("金士顿")
                .screen("三星")
                .build();
        System.out.println(phone);
    }
}
