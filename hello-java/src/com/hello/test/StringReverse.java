package com.hello.test;

import java.util.Stack;

/**
 * 字符串反转
 */
public class StringReverse {
    public static void main(String[] args) {
        String str = "你好，hiahia";
        System.out.println(str.length());
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        System.out.println(demo_1(str));
        System.out.println(demo_2(str));
        System.out.println(demo_3(str));

        System.out.println(demo_4(str));

        System.out.println(demo_5(str));
        System.out.println(demo_6(str));
        System.out.println(demo_7(str));

    }


    /**
     * 调用StringBuffer中的reverse方法
     *
     * @param str
     * @return
     */
    public static String demo_1(String str){
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * 把字符串转换成字符数组倒叙拼接然后返回值
     *
     * @param str
     * @return
     */
    public static String demo_2(String str){
        char[] chars = str.toCharArray();
        String reverse = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reverse += chars[i];
        }
        return reverse;
    }

    /**
     * 通过 charAt(int index)返回char值进行字符串拼接
     *
     * @param str
     * @return
     */
    public static String demo_3(String str){
        String reverse = "";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            reverse = str.charAt(i) + reverse;
        }
        return reverse;
    }

    /**
     * 递归方法
     *
     * @param str
     * @return
     */
    public static String demo_4(String str){
        int length = str.length();
        if (length <= 1){
            return str;
        }
        String left = str.substring(0, length / 2);
        String right = str.substring(length / 2, length);
        return demo_4(right) + demo_4(left);
    }

    /**
     * 把字符串转换成字符数组首位对调位置
     *
     * @param str
     * @return
     */
    public static String demo_5(String str){
        char[] s = str.toCharArray();
        int n = s.length - 1;
        int halfLength = n / 2;
        for (int i = 0; i <= halfLength; i++) {
            char temp = s[i];
            s[i] = s[n - i];
            s[n - i] = temp;
        }
        return new String(s);
    }

    public static String demo_6(String s){
        char[] str = s.toCharArray();
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            str[begin] = (char) (str[begin] ^ str[end]);
            str[end] = (char) (str[begin] ^ str[end]);
            str[begin] = (char) (str[end] ^ str[begin]);
            begin++;
            end--;
        }
        return new String(str);
    }

    public static String demo_7(String s){
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length; i++)
            stack.push(str[i]);

        String reversed = "";
        for (int i = 0; i < str.length; i++)
            reversed += stack.pop();
        return reversed;
    }

}
