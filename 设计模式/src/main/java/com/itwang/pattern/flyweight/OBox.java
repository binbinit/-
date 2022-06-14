package com.itwang.pattern.flyweight;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 18:35
 * @Description: O图形类(具体享元角色)
 */
public class OBox extends AbstractBox{
    @Override
    public String getShape() {
        return "O";
    }
}
