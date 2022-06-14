package com.itwang.pattern.combination;

/**
 * @Author: ww
 * @DateTime: 2022/4/16 18:06
 * @Description: 菜单项类(叶子结点角色)
 */
public class MenuItem extends MenuComponent {

    public MenuItem(String name,int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        // 打印菜单项的名称
        for (int i = 1; i < level; i++) {
            System.out.print("---");
        }
        System.out.println(name);
    }
}
