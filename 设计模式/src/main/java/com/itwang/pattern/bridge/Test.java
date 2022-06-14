package com.itwang.pattern.bridge;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 16:56
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        OperatingSystemVersion os = new Windows(new AviFile());
        os.play("葫芦娃");
    }
}
