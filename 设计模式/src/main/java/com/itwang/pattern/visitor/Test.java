package com.itwang.pattern.visitor;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:38
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        Home home = new Home();
        home.add(new Dog());
        home.add(new Cat());

        Owner owner = new Owner();
        home.action(owner);

        Someone someone = new Someone();
        home.action(someone);
    }
}
