package com.itwang.pattern.command;

import java.util.Map;
import java.util.Set;

/**
 * @Author: ww
 * @DateTime: 2022/4/17 14:42
 * @Description: 具体命令类
 */
public class OrderCommand implements Command{

    // 持有接受者对象
    private SeniorChef receiver;
    private Order order;

    public OrderCommand(SeniorChef receiver, Order order) {
        this.receiver = receiver;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable() + "桌的订单：");
        Map<String, Integer> foodDir = order.getFoodDir();
        // 遍历map集合
        Set<String> keys = foodDir.keySet();
        for (String foodName : keys) {
            receiver.makeFood(foodName, foodDir.get(foodName));
        }

        System.out.println(order.getDiningTable() + "桌的饭做好了");
    }
}
