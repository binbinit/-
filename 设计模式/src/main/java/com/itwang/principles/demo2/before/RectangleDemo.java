package com.itwang.principles.demo2.before;

//测试类
public class RectangleDemo {
    public static void main(String[] args) {
        //1.创建长方形对象
        Rectangle r = new Rectangle();
        //2.设置长和宽
        r.setLength(20);
        r.setWidth(10);
        //3.扩宽
        resize(r);
        //4.打印
        printLengthAndWidth(r);

        System.out.println("===========================");
        //1.创建正方形对象
        Square s = new Square();
        //2.设置长和宽
        s.setLength(10);
        //3.扩宽
        resize(s);
        //4.打印
        printLengthAndWidth(s);

    }

    //扩宽方法
    public static void resize(Rectangle rectangle){
        //判断宽如果比长小，进行扩宽操作
        while (rectangle.getWidth() <= rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    //打印长和宽
    public static void printLengthAndWidth(Rectangle rectangle){
        System.out.println("长为："+rectangle.getLength());
        System.out.println("宽为："+rectangle.getWidth());
    }
}
