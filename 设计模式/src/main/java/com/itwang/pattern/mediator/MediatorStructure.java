package com.itwang.pattern.mediator;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:37
 * @Description: 具体的中介者角色类
 */
public class MediatorStructure extends Mediator{

    // 聚合租房者和房主对象
    private HouseOwner houseOwner;
    private Tenant tenant;

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public void contact(String message, Person person) {
        //如果是房主，则租房者获得信息
        if (person == houseOwner) {
            tenant.getMessage(message);
        } else {    //反则是房主获得信息
            houseOwner.getMessage(message);
        }
    }
}
