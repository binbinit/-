package com.itwang.principles.demo4.before;

public class CCSafetyDoor implements SafetyDoor{

    @Override
    public void antiTheft() {
        System.out.println("防盗功能");
    }

    @Override
    public void fireProof() {
        System.out.println("防火功能");
    }

    @Override
    public void waterProof() {
        System.out.println("防水功能");
    }
}
