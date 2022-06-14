package com.itwang.pattern.flyweight;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 18:35
 * @Description: I图形类(具体享元角色)
 */
public class IBox extends AbstractBox{
    @Override
    public String getShape() {
        return "I";
    }
}
