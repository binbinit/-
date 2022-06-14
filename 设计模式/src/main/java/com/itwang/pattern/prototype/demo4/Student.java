package com.itwang.pattern.prototype.demo4;

import java.io.Serializable;

/**
 * @Author: ww
 * @DateTime: 2022/4/13 21:39
 * @Description: TODO
 */
public class Student implements Serializable {

    // 学生的姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
