package com.itwang.pattern.adapter.object_adapter;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 20:53
 * @Description: 适配者类的接口
 */
public interface TFCard {

    // 读取
    String readTF();

    // 写入
    void writeTF(String msg);
}
