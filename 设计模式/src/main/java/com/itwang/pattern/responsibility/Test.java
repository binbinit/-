package com.itwang.pattern.responsibility;

/**
 * @Author: ww
 * @DateTime: 2022/4/17 18:46
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        // 创建请假条对象
        LeaveRequest leave = new LeaveRequest("小龙",8,"回家当卷王");

        // 创建各级领导对象
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();

        // 设置处理者链
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        groupLeader.submit(leave);
    }
}
