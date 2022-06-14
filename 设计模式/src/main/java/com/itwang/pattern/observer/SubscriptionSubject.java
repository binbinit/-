package com.itwang.pattern.observer;

import com.itwang.pattern.state.after.LiftState;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:12
 * @Description: 具体被观察者
 */
public class SubscriptionSubject implements Subject{
    // 定义一个集合，用来存储多个观察者对象
    private List<Observer> weiXinUserList = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        weiXinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weiXinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weiXinUserList) {
            observer.update(message);
        }
    }
}
