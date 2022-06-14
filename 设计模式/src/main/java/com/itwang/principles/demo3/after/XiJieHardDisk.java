package com.itwang.principles.demo3.after;

// 硬盘
public class XiJieHardDisk implements HardDisk{

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
