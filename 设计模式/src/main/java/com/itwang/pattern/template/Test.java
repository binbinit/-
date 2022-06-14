package com.itwang.pattern.template;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:20
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        //炒手撕包菜
        ConcreteClass_BaoCai baoCai = new ConcreteClass_BaoCai();
        baoCai.cookProcess();

        //炒蒜蓉菜心
        ConcreteClass_CaiXin caiXin = new ConcreteClass_CaiXin();
        caiXin.cookProcess();
    }
}
