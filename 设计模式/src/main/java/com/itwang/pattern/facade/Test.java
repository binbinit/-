package com.itwang.pattern.facade;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 17:12
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        SmartAppliancesFacade smartAppliancesFacade = new SmartAppliancesFacade();
        smartAppliancesFacade.say("全部打开");
        System.out.println("=================");
        smartAppliancesFacade.say("全部关闭");
    }
}
