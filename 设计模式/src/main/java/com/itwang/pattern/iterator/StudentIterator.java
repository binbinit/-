package com.itwang.pattern.iterator;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:51
 * @Description: 抽象迭代器角色接口
 */
public interface StudentIterator {
    // 判断是否还有元素
    boolean hasNext();
    // 获取下一个元素
    Student next();
}
