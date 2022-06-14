package com.itwang.principles.demo1;

//开闭原则
// 测试类
public class Client {
    public static void main(String[] args) {
        //1.创建搜狗输入法对象
        SougouInput sougouInput = new SougouInput();

        //2.创建皮肤对象
        //使用默认皮肤
        //DefaultSkin defaultSkin = new DefaultSkin();
        //使用自定义皮肤
        SelfSkin selfSkin = new SelfSkin();

        //3.将皮肤设置到输入法中
        sougouInput.setSkin(selfSkin);

        //4.显示皮肤
        sougouInput.display();
    }
}
