package com.itwang.pattern.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 18:00
 * @Description: 菜单类(树枝结点)
 */
public class Menu extends MenuComponent{
    private List<MenuComponent> menuComponentList = new ArrayList<MenuComponent>();

    public Menu(String name, int level){
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponentList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int index) {
        return menuComponentList.get(index);
    }

    @Override
    public void print() {
        // 打印菜单名称
        for (int i = 1; i < level; i++) {
            System.out.print("---");
        }
        System.out.println(name);
        // 打印子菜单和菜单项
        for (MenuComponent component : menuComponentList) {
            component.print();
        }
    }
}
