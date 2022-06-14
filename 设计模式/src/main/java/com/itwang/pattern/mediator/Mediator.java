package com.itwang.pattern.mediator;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:30
 * @Description: 抽象中介者类
 */
public abstract class Mediator {
    public abstract void contact(String message, Person person);
}
