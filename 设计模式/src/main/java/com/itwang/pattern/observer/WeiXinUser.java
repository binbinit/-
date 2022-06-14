package com.itwang.pattern.observer;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:14
 * @Description: 具体观察者角色类
 */
public class WeiXinUser implements Observer{

    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
