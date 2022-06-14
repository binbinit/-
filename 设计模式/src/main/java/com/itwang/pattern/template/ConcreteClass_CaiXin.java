package com.itwang.pattern.template;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:19
 * @Description: TODO
 */
public class ConcreteClass_CaiXin extends AbstractClass{
    @Override
    public void pourVegetable() {
        System.out.println("下锅的蔬菜是菜心");
    }

    @Override
    public void pourSauce() {
        System.out.println("下锅的酱料是蒜蓉");
    }
}
