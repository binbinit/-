package com.itwang.pattern.decorator;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:46
 * @Description: 炒饭类(具体构建角色)
 */
public class FriedRice extends FastFood{
    public FriedRice(){
        super(10,"炒饭");
    }
    @Override
    public float cost() {
        return getPrice();
    }
}
