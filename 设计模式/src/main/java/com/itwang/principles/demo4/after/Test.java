package com.itwang.principles.demo4.after;

/**
 * @Author: ww
 * @DateTime: 2022/4/10 18:05
 * @Description: 测试类
 */
public class Test {

    public static void main(String[] args) {
        LLSafetyDoor door = new LLSafetyDoor();
        door.antiTheft();
        door.fireproof();
        door.waterproof();

        CCSafetyDoor ccSafetyDoor = new CCSafetyDoor();
        ccSafetyDoor.antiTheft();
    }
}
