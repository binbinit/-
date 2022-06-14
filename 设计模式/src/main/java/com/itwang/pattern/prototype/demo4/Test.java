package com.itwang.pattern.prototype.demo4;

import java.io.*;

/**
 * @Author: ww
 * @DateTime: 2022/4/13 21:34
 * @Description: TODO
 */
public class Test {
        public static void main(String[] args) throws CloneNotSupportedException, Exception {
                // 1.获取原型对象
                Citation citation = new Citation();
                // 创建CC学生对象
                Student stu = new Student();
                stu.setName("CC");
                citation.setStudent(stu);

                //创建对象输出流对象
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\workspace\\a.txt"));
                oos.writeObject(citation);
                oos.close();

                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\workspace\\a.txt"));
                Citation citation1 = (Citation)ois.readObject();
                ois.close();
                Student stu1 = citation1.getStudent();
                stu1.setName("龙龙");

                citation.show();
                citation1.show();

        }
}
