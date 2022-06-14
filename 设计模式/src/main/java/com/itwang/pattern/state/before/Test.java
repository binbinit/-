package com.itwang.pattern.state.before;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 17:26
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        Lift lift = new Lift();
        lift.setState(ILift.STOPPING_STATE);//电梯是停止的
        lift.open();//开门
        lift.close();//关门
        lift.run();//运行
        lift.stop();//停止
    }
}
