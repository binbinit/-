package com.itwang.pattern.mediator;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:33
 * @Description: 具体同事角色类
 */
public class Tenant extends Person {
    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    // 和中介沟通的方法
    public void contact(String message) {
        mediator.contact(message, this);
    }

    // 获取信息的方法
    public void getMessage(String message){
        System.out.println("租房者" + name +"获取到的信息：" + message);
    }
}
