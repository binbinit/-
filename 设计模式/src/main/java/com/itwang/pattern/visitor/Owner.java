package com.itwang.pattern.visitor;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:35
 * @Description: 具体访问者角色类
 */
public class Owner implements Person{
    @Override
    public void feed(Cat cat) {
        System.out.println("主人喂猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("主人喂狗");
    }
}
