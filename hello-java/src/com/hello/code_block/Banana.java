package com.hello.code_block;

public class Banana extends Fruit{

    private static Foo foo = new Foo("我是子类静态成员变量foo");
    private Foo fo1 = new Foo("我是子类成员变量fo");

    private String name = "我是子类成员变量name-banana";

    static {
        System.out.println("我是子类静态代码块");  // 只在第一次调用的时候执行,优先级最高
    }

    {
        System.out.println("我是子类构造代码块"); // 每次被新对象调用时都执行,优先级在静态代码块之后
    }

    private Foo fo2 = new Foo("我是子类成员变量fo2");

    public Banana() {
        super();
        System.out.println("我是子类无参构造方法");

    }

    public Banana(String str) {
        super();
        System.out.println("我是子类代参构造方法：" + str);

    }

    public void method() {
        System.out.println("我是子类类成员方法" + "香蕉是长的");
    }

}
