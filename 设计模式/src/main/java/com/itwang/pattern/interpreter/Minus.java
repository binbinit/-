package com.itwang.pattern.interpreter;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:50
 * @Description: 减法表达式(非终结符表达式角色)
 */
public class Minus extends AbstractExpression{

    // -号左右两边的表达式
    private AbstractExpression left;
    private AbstractExpression right;

    public Minus(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " - " + right.toString() + ")";
    }
}
