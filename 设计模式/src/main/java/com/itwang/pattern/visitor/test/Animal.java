package com.itwang.pattern.visitor.test;

/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:47
 * @Description: TODO
 */
public class Animal {
}

 class Dog extends Animal {
}

 class Cat extends Animal {
}

 class Execute {
    public void execute(Animal a) {
        System.out.println("Animal");
    }

    public void execute(Dog d) {
        System.out.println("dog");
    }

    public void execute(Cat c) {
        System.out.println("cat");
    }
}

 class Client {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        Execute exe = new Execute();
        exe.execute(a);
        exe.execute(a1);
        exe.execute(a2);
    }
}
