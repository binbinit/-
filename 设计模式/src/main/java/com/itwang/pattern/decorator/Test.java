package com.itwang.pattern.decorator;

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:55
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        // 点一份炒饭
        FastFood food = new FriedRice();
        System.out.println(food.getDesc()+ " "+ food.cost());
        System.out.println("=============================");
        // 加个鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc()+ " "+ food.cost());
        System.out.println("=============================");
        // 再加个鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc()+ " "+ food.cost());
        System.out.println("=============================");
        // 加个培根
        food = new Bacon(food);
        System.out.println(food.getDesc()+ " "+ food.cost());
    }
}
