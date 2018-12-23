package com.hello.clazz;

public class Cat extends Animal{
    // 重写(Override)
    public void move(){
        System.out.println("猫可以瞎走");
    }
    // 重载(Overload)
    public void move(String order){
        System.out.println("猫可以走直线");
    }

}
