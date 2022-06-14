package com.itwang.principles.demo1;

public class SougouInput {
    private AbstractSkin abstractSkin;

    public void setSkin(AbstractSkin abstractSkin){
        this.abstractSkin = abstractSkin;
    }

    public void display(){
        abstractSkin.display();
    }
}
