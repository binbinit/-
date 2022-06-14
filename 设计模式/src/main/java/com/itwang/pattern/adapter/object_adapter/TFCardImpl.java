package com.itwang.pattern.adapter.object_adapter;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 20:57
 * @Description: 适配者类
 */
public class TFCardImpl implements TFCard {
    @Override
    public String readTF() {
        String msg = "TFCard read msg: hello TFCard";
        return msg;
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TFCard:"+msg);
    }
}
