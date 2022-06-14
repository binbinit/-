package com.itwang.pattern.adapter.class_adapter;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:03
 * @Description: 计算机类
 */
public class Computer  {

    // 从SD卡中读取数据
    public String readSD(SDCard sdCard){
        if (sdCard == null){
            throw new NullPointerException("sdcard is not null");
        }
        return sdCard.readSD();
    }
}
