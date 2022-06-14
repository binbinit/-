package com.itwang.pattern.prototype.demo3;

/**
 * @Author: ww
 * @DateTime: 2022/4/13 21:34
 * @Description: TODO
 */
public class Test {
        public static void main(String[] args) throws CloneNotSupportedException {
                // 1.获取原型对象
                Citation citation = new Citation();
                // 创建CC学生对象
                Student student = new Student();
                student.setName("CC");
                citation.setStudent(student);
                // 2.获取奖状对象
                Citation citation1 = citation.clone();
                Student student1 = citation1.getStudent();
                student1.setName("龙龙");

                citation.show();
                citation1.show();

                // 浅克隆
                //龙龙同学：在2022学年第一学期中表现优秀，被评为三好学生。特发此状！
                //龙龙同学：在2022学年第一学期中表现优秀，被评为三好学生。特发此状！

        }
}
