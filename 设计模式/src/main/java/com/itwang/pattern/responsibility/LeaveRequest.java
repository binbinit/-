package com.itwang.pattern.responsibility;

/**
 * @Author: ww
 * @DateTime: 2022/4/17 18:32
 * @Description: 请假条类
 */
public class LeaveRequest {

    // 姓名
    private String name;
    // 请假天数
    private int num;
    // 请假内容
    private String content;

    public LeaveRequest(String name, int num, String content) {
        this.name = name;
        this.num = num;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getContent() {
        return content;
    }
}
