package com.itwang.pattern.observer;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:16
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        SubscriptionSubject mSubscriptionSubject=new SubscriptionSubject();
        //创建微信用户
        WeiXinUser user1 = new WeiXinUser("卷王1");
        WeiXinUser user2 = new WeiXinUser("卷王2");
        WeiXinUser user3 = new WeiXinUser("卷王3");
        //订阅公众号
        mSubscriptionSubject.attach(user1);
        mSubscriptionSubject.attach(user2);
        mSubscriptionSubject.attach(user3);
        //公众号更新发出消息给订阅的微信用户
        mSubscriptionSubject.notify("反卷专栏更新了");
    }
}
