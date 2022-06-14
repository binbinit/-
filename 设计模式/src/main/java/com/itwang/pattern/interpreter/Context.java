package com.itwang.pattern.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:47
 * @Description: 环境角色类
 */
public class Context {
    // 存储变量及其对应的值
    private Map<Variable, Integer> map = new HashMap<Variable, Integer>();

    // 添加
    public void assign(Variable var, Integer value) {
        map.put(var, value);
    }

    // 获取
    public int getValue(Variable var) {
        Integer value = map.get(var);
        return value;
    }
}
