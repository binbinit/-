package com.itwang.pattern.bridge;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 16:51
 * @Description: rmvb视频文件(具体实现化角色)
 */
public class RmvbFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("rmvb文件：" + fileName);
    }
}
