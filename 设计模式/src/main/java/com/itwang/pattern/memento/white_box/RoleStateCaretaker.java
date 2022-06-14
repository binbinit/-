package com.itwang.pattern.memento.white_box;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:06
 * @Description: 备忘录对象管理角色
 */
public class RoleStateCaretaker {
    // 声明备忘录对象
    private RoleStateMemento roleStateMemento;

    public RoleStateMemento getRoleStateMemento() {
        return roleStateMemento;
    }

    public void setRoleStateMemento(RoleStateMemento roleStateMemento) {
        this.roleStateMemento = roleStateMemento;
    }
}
