package com.itwang.principles.demo5;

/**
 * @Author: ww
 * @DateTime: 2022/4/10 18:38
 * @Description: 测试类
 */
public class Test {
    public static void main(String[] args) {
        Agent agent = new Agent();
        Star star = new Star("cc");
        agent.setStar(star);
        Fans fans = new Fans("ll");
        agent.setFans(fans);
        Company company = new Company("某豆");
        agent.setCompany(company);
        agent.meeting();
        agent.business();
    }
}
