package com.itwang.pattern.bridge;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 16:55
 * @Description: mac(扩展抽象化角色)
 */
public class Mac extends OperatingSystemVersion{
    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
