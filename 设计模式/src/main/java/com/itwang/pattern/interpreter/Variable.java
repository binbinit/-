package com.itwang.pattern.interpreter;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:48
 * @Description: 封装变量的类
 */
public class Variable extends AbstractExpression{

    // 声明存储变量名的存储变量
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        // 返回变量的值
        return context.getValue(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
