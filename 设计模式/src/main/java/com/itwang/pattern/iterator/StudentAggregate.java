package com.itwang.pattern.iterator;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:54
 * @Description: 抽象聚合角色接口
 */
public interface StudentAggregate {
    // 添加学生
    void addStudent(Student student);

    // 删除学生
    void removeStudent(Student student);

    // 获取迭代器对象
    StudentIterator getStudentIterator();
}
