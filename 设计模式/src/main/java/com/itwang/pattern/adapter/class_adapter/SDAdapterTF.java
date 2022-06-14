package com.itwang.pattern.adapter.class_adapter;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:09
 * @Description: 适配器类
 */
public class SDAdapterTF extends TFCardImpl implements SDCard{
    @Override
    public String readSD() {
        System.out.println("adapter read tf card ");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card ");
        writeTF(msg);
    }
}
