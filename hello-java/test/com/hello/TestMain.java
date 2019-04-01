package com.hello;

public class TestMain {
    public static void main(String[] args) {
        int a = 9;

        TestMain mt = new TestMain();
        mt.add1(9);
        System.out.println(a);

        Myobj obj = new Myobj();

        mt.add2(obj);
        System.out.println(obj.b);

    }

    private final void add1(int a){
        a++;
        System.out.println(a);
    }

    private final void add2(Myobj obj){
        obj.b++;
        System.out.println(obj.b);
    }

}

class Myobj{
    public int b = 9;
}