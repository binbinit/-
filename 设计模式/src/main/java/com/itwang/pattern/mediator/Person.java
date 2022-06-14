package com.itwang.pattern.mediator;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:32
 * @Description: 抽象同事类
 */
public abstract class Person {
    protected String name;
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
