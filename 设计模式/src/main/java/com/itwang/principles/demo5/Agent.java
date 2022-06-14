package com.itwang.principles.demo5;

/**
 * @Author: ww
 * @DateTime: 2022/4/10 18:26
 * @Description: 经纪人类
 */
public class Agent {
    private Star star;
    private Fans fans;
    private Company company;

    public void setStar(Star star) {
        this.star = star;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    //和粉丝见面的方法
    public void meeting(){
        System.out.println("大明星" + star.getName() + "和粉丝" + fans.getName() + "见见面");
    }

    //和媒体公司洽谈的方法
    public void business(){
        System.out.println(star.getName() + "和" + company.getName() + "洽谈");
    }
}
