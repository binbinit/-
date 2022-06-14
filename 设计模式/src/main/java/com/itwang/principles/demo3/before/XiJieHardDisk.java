package com.itwang.principles.demo3.before;

// 硬盘
public class XiJieHardDisk {

    //存储数据
    public void save(String data){
        System.out.println("使用硬盘存储数据："+data);
    }

    //获取数据
    public String get(){
        System.out.println("使用硬盘获取数据");
        return "数据";
    }
}
