package com.itwang.pattern.command;

/**
 * @Author: ww
 * @DateTime: 2022/4/17 14:41
 * @Description: 抽象命令类
 */
public interface Command {
    //只需要定义一个统一的执行方法
    void execute();
}
