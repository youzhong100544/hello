package com.hello.clazz;

public class Fruit {

    private String name;

    public Fruit(){ }

    public Fruit(String name){
        this.name = name;
    }

    public void taste(String taste){
        if (taste == null)
            System.out.println("It's tastes sweet");
        else
            System.out.println("It's tastes " + taste);
    }

}
