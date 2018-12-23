package com.hello.clazz;

public class Employee{
    Object work(Object task){
        Object result = doWork(task);
        return result;
    }

    Object doWork(Object task){
        Object result = task;
        return result;
    }

    String speak(){
        return "im smployee";
    }

}
