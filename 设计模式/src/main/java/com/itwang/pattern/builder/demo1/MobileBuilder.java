package com.itwang.pattern.builder.demo1;

/**
 * @Author: ww
 * @DateTime: 2022/4/14 19:30
 * @Description: 具体构造类
 */
public class MobileBuilder extends Builder{
    @Override
    public void builderFrame() {
        bike.setFrame("C牌车架");
    }

    @Override
    public void builderSeat() {
        bike.setSeat("龙牌车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
