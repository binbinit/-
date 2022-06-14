package com.itwang.pattern.builder.demo1;

/**
 * @Author: ww
 * @DateTime: 2022/4/14 19:27
 * @Description: 产品对象
 */
public class Bike {

    // 车架
    private String frame;
    // 车座
    private String seat;

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
