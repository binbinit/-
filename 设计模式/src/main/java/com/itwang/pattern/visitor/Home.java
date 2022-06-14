package com.itwang.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:36
 * @Description: 对象结构类
 */
public class Home {

    private List<Animal> nodeList = new ArrayList<Animal>();

    //添加元素
    public void add(Animal animal) {
        nodeList.add(animal);
    }

    public void action(Person person) {
        for (Animal node : nodeList) {
            node.accept(person);
        }
    }
}
