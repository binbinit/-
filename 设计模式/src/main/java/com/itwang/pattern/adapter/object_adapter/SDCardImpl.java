package com.itwang.pattern.adapter.object_adapter;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:01
 * @Description: TODO
 */
public class SDCardImpl implements SDCard {
    @Override
    public String readSD() {
        String msg = "SDCard read msg: hello SDCard";
        return msg;
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SDCard:"+msg);
    }
}
