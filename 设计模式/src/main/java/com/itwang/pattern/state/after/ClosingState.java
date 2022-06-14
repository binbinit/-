package com.itwang.pattern.state.after;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 17:38
 * @Description: 关闭
 */
public class ClosingState extends LiftState{
    @Override
    //电梯门关闭，这是关闭状态要实现的动作
    public void close() {
        System.out.println("电梯门关闭...");
    }

    //电梯门关了再打开
    @Override
    public void open() {
        super.context.setLiftState(Context.openningState);
        super.context.open();
    }

    //电梯门关了就跑
    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.run();
    }

    //电梯门关着，我就不按楼层
    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.stop();
    }
}
