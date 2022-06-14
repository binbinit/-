package com.itwang.pattern.responsibility;

/**
 * @Author: ww
 * @DateTime: 2022/4/17 18:41
 * @Description: 小组长类(具体的处理者)
 */
public class GroupLeader extends Handler {

    public GroupLeader(){
        //小组长处理1-3天的请假
        super(0,Handler.NUM_ONE);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        if (leave.getNum() <= NUM_ONE){
            System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
            System.out.println("小组长审批：同意。");
        }else {
            System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
            System.out.println("小组长审批：太久了，请找部门经理");
        }
    }
}
