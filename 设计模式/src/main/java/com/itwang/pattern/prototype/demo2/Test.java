package com.itwang.pattern.prototype.demo2;/**
 * @Author: ww
 * @DateTime: 2022/4/13 21:34
 * @Description: TODO
 */
public class Test {
        public static void main(String[] args) throws CloneNotSupportedException {
                // 1.获取原型对象
                Citation citation = new Citation();
                // 2.获取奖状对象
                Citation citation1 = citation.clone();

                citation.setName("CC");
                citation1.setName("龙龙");

                citation.show();
                citation1.show();

        }
}
