package com.itwang.pattern.state.after;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 17:34
 * @Description: 环境角色类
 */
public class Context {
    //定义出所有的电梯状态
    public final static OpenningState openningState = new OpenningState(); //开门状态，这时候电梯只能关闭
    public final static ClosingState closeingState = new ClosingState(); //关闭状态，这时候电梯可以运行、停止和开门
    public final static RunningState runningState = new RunningState(); //运行状态，这时候电梯只能停止
    public final static StoppingState stoppingState = new StoppingState(); //停止状态，这时候电梯可以开门、运行

    //定义一个当前电梯状态变量
    private LiftState liftState;

    public LiftState getLiftState() {
        return this.liftState;
    }

    // 设置当前状态对象
    public void setLiftState(LiftState liftState) {
        // 当前环境改变
        this.liftState = liftState;
        // 设置当前状态对象中的Context对象
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }
}
