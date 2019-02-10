package com.hello.util;

/**
 * 工具类--变量交换
 */
public class SwitchVariable {

    public static void main(String[] args) {
        demo_1(2, 7);

        demo_2(1, 7);


    }

    public static void demo_1(int a, int b){
        System.out.println("input string :: a = " + a + ", b= " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("output string :: a = " + a + ", b= " + b);
    }

    /**
     * 通过第三方变量实现两个变量的交换
     *
     * @param a
     *      变量a
     * @param b
     *      变量b
     */
    public static void demo_2(int a, int b){
        System.out.println("input string :: a = " + a + ", b= " + b);

        int temp;
        temp = a;
        a = b;
        b = temp;

        System.out.println("output string :: a = " + a + ", b= " + b);
    }

    public static void demo_2_1(String a, String b){
        System.out.println("input string :: a = " + a + ", b= " + b);


        System.out.println("output string :: a = " + a + ", b= " + b);
    }

    public static void demo_2_2(Object a, Object b){
        System.out.println("input Object :: a = " + a + ", b= " + b);


        System.out.println("output Object :: a = " + a + ", b= " + b);
    }

}
