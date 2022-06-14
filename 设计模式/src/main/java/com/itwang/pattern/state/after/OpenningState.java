package com.itwang.pattern.state.after;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 17:37
 * @Description: 电梯开启状态类
 */
public class OpenningState extends LiftState{
    @Override
    public void open() {
        System.out.println("电梯开启");
    }

    @Override
    public void close() {
        // 状态修改
        super.context.setLiftState(Context.closeingState);
        // 调用当前状态中的Context中的close方法
        super.context.getLiftState().close();
    }

    @Override
    public void run() {
    }

    @Override
    public void stop() {
    }
}
