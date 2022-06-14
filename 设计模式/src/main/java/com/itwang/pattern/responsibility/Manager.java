package com.itwang.pattern.responsibility;

/**
 * @Author: ww
 * @DateTime: 2022/4/17 18:43
 * @Description: 部门经理(具体的处理者)
 */
public class Manager extends Handler{

    public Manager(){
        super(Handler.NUM_ONE,Handler.NUM_THREE);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        if (leave.getNum() <= Handler.NUM_THREE){
            System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
            System.out.println("部门经理审批：同意。");
        } else {
            System.out.println("部门经理审批：太久了，请找总经理");
        }
    }
}
