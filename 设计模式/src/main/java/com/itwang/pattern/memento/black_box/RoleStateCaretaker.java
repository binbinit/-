package com.itwang.pattern.memento.black_box;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:06
 * @Description: 备忘录对象管理角色
 */
public class RoleStateCaretaker {
    // 声明备忘录对象
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
