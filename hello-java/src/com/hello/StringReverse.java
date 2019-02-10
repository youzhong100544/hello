package com.hello;

/**
 * 字符串反转
 */
public class StringReverse {
    public static void main(String[] args) {
        String str = "你好，hiahia";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        System.out.println(demo_1(str));
        System.out.println(demo_2(str));
        System.out.println(demo_3(str));

    }



    public static String demo_1(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static String demo_2(String str){
        char[] chars = str.toCharArray();
        String reverse = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reverse += chars[i];
        }
        return reverse;
    }

    public static String demo_3(String str){
        String reverse = "";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            reverse = str.charAt(i) + reverse;
        }
        return reverse;
    }
}
