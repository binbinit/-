package com.itwang.principles.demo4.after;

/**
 * @Author: ww
 * @DateTime: 2022/4/10 18:05
 * @Description: TODO
 */
public class LLSafetyDoor implements AntiTheft, Fireproof, Waterproof{
    @Override
    public void antiTheft() {
        System.out.println("防盗");
    }

    @Override
    public void fireproof() {
        System.out.println("防火");
    }

    @Override
    public void waterproof() {
        System.out.println("防水");
    }
}
