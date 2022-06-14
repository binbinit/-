package com.itwang.pattern.flyweight;

import javax.swing.*;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 18:41
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        // 获取I图形对象
        AbstractBox i = BoxFactory.getInstance().getShape("I");
        i.display("red");
        // 获取L图形对象
        AbstractBox l = BoxFactory.getInstance().getShape("L");
        l.display("yellow");
        // 获取O图形对象
        AbstractBox o = BoxFactory.getInstance().getShape("O");
        o.display("black");
        AbstractBox o1 = BoxFactory.getInstance().getShape("O");
        o1.display("blue");

        System.out.println(o == o1);
    }
}
