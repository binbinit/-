package com.itwang.pattern.state.after;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 17:34
 * @Description: 抽象状态类
 */
public abstract class LiftState {

    // 声明环境角色类变量
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    // 电梯开启
    public abstract void open();
    // 电梯关闭
    public abstract void close();
    // 电梯运行
    public abstract void run();
    // 电梯停止
    public abstract void stop();
}
