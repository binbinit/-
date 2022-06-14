package com.itwang.pattern.combination;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 17:54
 * @Description: 菜单组件类(抽象根结点)
 */
public abstract class MenuComponent {
    protected String name;
    //  菜单层级
    protected int level;

    //添加菜单
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    //移除菜单
    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    //获取指定的子菜单
    public MenuComponent getChild(int index){
        throw new UnsupportedOperationException();
    }

    //获取菜单名称
    public String getName(){
        return name;
    }

    // 打印菜单名称的方法(包含子菜单和菜单项)
    public abstract void print();
}
