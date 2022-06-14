package com.itwang.pattern.bridge;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 16:54
 * @Description: windows(扩展抽象化角色)
 */
public class Windows extends OperatingSystemVersion{
    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
