package com.itwang.pattern.builder.demo1;

/**
 * @Author: ww
 * @DateTime: 2022/4/14 19:32
 * @Description: 具体构建类
 */
public class OfoBuilder extends Builder{
    @Override
    public void builderFrame() {
        bike.setFrame("314车架");
    }

    @Override
    public void builderSeat() {
        bike.setSeat("ll车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
