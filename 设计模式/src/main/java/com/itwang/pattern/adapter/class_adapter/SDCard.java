package com.itwang.pattern.adapter.class_adapter;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:00
 * @Description: 目标接口
 */
public interface SDCard {
    // 读取
    String readSD();
    // 写入
    void writeSD(String msg);
}
