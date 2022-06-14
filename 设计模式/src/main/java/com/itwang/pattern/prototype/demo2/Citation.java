package com.itwang.pattern.prototype.demo2;

/**
 * @Author: ww
 * @DateTime: 2022/4/13 21:32
 * @Description: TODO
 */
public class Citation implements Cloneable{

    // 三好学生上的姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {

        return (Citation)super.clone();
    }

    public void show() {
        System.out.println(name + "同学：在2022学年第一学期中表现优秀，被评为三好学生。特发此状！");
    }
}
