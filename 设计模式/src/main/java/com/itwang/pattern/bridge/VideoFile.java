package com.itwang.pattern.bridge;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 16:47
 * @Description: 视频文件(实现化角色)
 */
public interface VideoFile  {
    // 解码
    void decode(String fileName);
}
