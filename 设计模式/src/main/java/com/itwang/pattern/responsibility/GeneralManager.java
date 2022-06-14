package com.itwang.pattern.responsibility;

/**
 * @Author: ww
 * @DateTime: 2022/4/17 18:45
 * @Description: 总经理(具体的处理者)
 */
public class GeneralManager extends Handler{
    public GeneralManager() {
        //部门经理处理7天以上的请假
        super(Handler.NUM_THREE,Handler.NUM_SEVEN);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        if (leave.getNum() <= Handler.NUM_SEVEN){
            System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
            System.out.println("总经理审批：同意。");
        } else{
            System.out.println("总经理审批：太久了，不同意");
        }
    }
}
