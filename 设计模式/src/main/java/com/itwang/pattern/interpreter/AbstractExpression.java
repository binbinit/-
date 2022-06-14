package com.itwang.pattern.interpreter;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:46
 * @Description: 抽象表达式类
 */
public abstract class AbstractExpression {
    public abstract int interpret(Context context);
}
