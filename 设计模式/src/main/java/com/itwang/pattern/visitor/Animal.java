package com.itwang.pattern.visitor;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:32
 * @Description: 持续角色元素类
 */
public interface Animal {

    // 接收访问者访问的功能
    void accept(Person person);
}
