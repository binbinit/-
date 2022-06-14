package com.itwang.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:55
 * @Description: 具体聚合角色类
 */
public class StudentAggregateImpl implements StudentAggregate{

    // 学生列表
    private List<Student> list = new ArrayList<Student>();

    @Override
    public void addStudent(Student student) {
        list.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        list.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(list);
    }
}
