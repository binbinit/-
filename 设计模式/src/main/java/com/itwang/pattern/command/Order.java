package com.itwang.pattern.command;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ww
 * @DateTime: 2022/4/17 14:37
 * @Description: 订单类
 */
public class Order {

    // 餐桌号码
    private int diningTable;

    // 所下的餐品和份数
    private Map<String,Integer> foodDir = new HashMap<String , Integer>();

    public int getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(int diningTable) {
        this.diningTable = diningTable;
    }

    public Map<String, Integer> getFoodDir() {
        return foodDir;
    }

    public void setFood(String name, int num) {
        foodDir.put(name,num);
    }
}
