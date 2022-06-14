package com.itwang.pattern.iterator;

import java.util.List;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:52
 * @Description: 具体迭代器角色类
 */
public class StudentIteratorImpl implements StudentIterator{

    private List<Student> list;
    // 遍历位置
    private int position = 0;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        Student currentStudent = list.get(position);
        position++;
        return currentStudent;
    }
}
