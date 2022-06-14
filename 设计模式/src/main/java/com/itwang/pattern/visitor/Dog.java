package com.itwang.pattern.visitor;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:33
 * @Description: 具体元素角色类
 */
public class Dog implements Animal{
    @Override
    public void accept(Person person) {
        // 访问者喂食
        person.feed(this);
        System.out.println("dog");
    }
}
