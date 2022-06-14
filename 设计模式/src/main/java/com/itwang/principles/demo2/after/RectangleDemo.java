package com.itwang.principles.demo2.after;

//测试类
public class RectangleDemo {
    public static void main(String[] args) {
        //创建长方形对象
        Rectangle r = new Rectangle();
        r.setLength(20);
        r.setWidth(10);
        resize(r);
        printLengthAndWidth(r);

        System.out.println("===============================");
        //无法创建正方形对象调用扩宽方法解决before问题
//        Square s = new Square();
//        s.setSide(5);
//        resize(s);
//        printLengthAndWidth(s);

    }

    //扩宽方法
    public static void resize(Rectangle rectangle){
        //判断宽如果比长小，进行扩宽操作
        while (rectangle.getWidth() <= rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    //打印长和宽
    public static void printLengthAndWidth(Quadrilateral quadrilateral){
        System.out.println("长为："+quadrilateral.getLength());
        System.out.println("宽为："+quadrilateral.getWidth());
    }
}
