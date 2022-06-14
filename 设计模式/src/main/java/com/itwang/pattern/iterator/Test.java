package com.itwang.pattern.iterator;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:57
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        // 创建聚合对象
        StudentAggregateImpl aggregate = new StudentAggregateImpl();
        // 添加元素
        aggregate.addStudent(new Student("张三","100000"));
        aggregate.addStudent(new Student("李四","100001"));
        aggregate.addStudent(new Student("王五","100002"));

        // 遍历聚合对象
        // 1.获取迭代器对象
        StudentIterator iterator = aggregate.getStudentIterator();
        // 2.遍历
        while (iterator.hasNext()){
            // 3.获取元素
            Student student = iterator.next();
            System.out.println(student.toString());
        }
    }
}
