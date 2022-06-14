package com.itwang.pattern.singleton.demo12;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: ww
 * @DateTime: 2022/4/11 20:02
 * @Description: TODO
 */
public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        // 1.获取Runtime类的对象
        Runtime runtime = Runtime.getRuntime();

        // 2.调用runtime的exec方法，参数要的是一个命令
        Process process = runtime.exec("ipconfig");

        // 3.调用process对象的获取输入流的方法
        InputStream is = process.getInputStream();
        byte[] arr = new byte[1034*1024*100];

        // 4.读取数据
        int len = is.read(arr); // 返回读取到的字节个数

        // 5.将字节数组转换为字符串输出到控制台
        System.out.println(new String(arr,0,len,"GBK"));

    }
}
