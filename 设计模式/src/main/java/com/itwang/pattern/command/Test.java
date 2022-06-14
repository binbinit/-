package com.itwang.pattern.command;

/**
 * @Author: ww
 * @DateTime: 2022/4/17 14:52
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        //创建2个order
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.setFood("炒面",1);
        order1.setFood("可乐",2);

        Order order2 = new Order();
        order2.setDiningTable(3);
        order2.setFood("粥",1);
        order2.setFood("雪碧",1);

        // 创建接收者
        SeniorChef receiver = new SeniorChef();
        //将订单和接收者封装成命令对象
        OrderCommand cmd1 = new OrderCommand(receiver, order1);
        OrderCommand cmd2 = new OrderCommand(receiver, order2);

        //创建调用者 waiter
        Waiter invoker = new Waiter();
        invoker.setCommands(cmd1);
        invoker.setCommands(cmd2);

        // waiter发起命令
        invoker.orderUp();
    }
}
