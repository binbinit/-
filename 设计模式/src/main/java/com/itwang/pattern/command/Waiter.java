package com.itwang.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ww
 * @DateTime: 2022/4/17 14:48
 * @Description: 服务员类(请求者角色)
 */
public class Waiter {

    // 持有多个命令对象
    private List<Command> commands = new ArrayList<Command>();

    public void setCommands(Command cmd){
        commands.add(cmd);
    }

    // 发起命令的方法
    public void orderUp(){
        System.out.println("服务员：新订单来了");
        for (Command command : commands) {
            if (command != null){
                command.execute();
            }
        }
    }
}
