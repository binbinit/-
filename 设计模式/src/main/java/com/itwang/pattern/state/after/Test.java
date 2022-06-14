package com.itwang.pattern.state.after;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 17:47
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new RunningState());

        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
