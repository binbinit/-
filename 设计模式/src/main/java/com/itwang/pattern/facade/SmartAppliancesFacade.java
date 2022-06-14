package com.itwang.pattern.facade;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 17:07
 * @Description: 外观类，用户主要和该类对象进行交互
 */
public class SmartAppliancesFacade {

    private Light light;
    private TV tv;
    private AirCondition airCondition;

    public SmartAppliancesFacade() {
        light = new Light();
        tv = new TV();
        airCondition = new AirCondition();
    }

    // 通过语音控制
    public void say(String message){
        if (message.contains("打开")){
            on();
        } else if (message.contains("关闭")){
            off();
        } else {
            System.out.println("小度已经断开了");
        }
    }

    // 一键打开
    public void on(){
        light.on();
        tv.on();
        airCondition.on();
    }

    // 一键关闭
    public void off(){
        light.off();
        tv.off();
        airCondition.off();
    }
}
