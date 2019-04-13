package com.hello;

/**
 * JDK1.5开始String类中提供
 */
public class DemoString {
    public static void main(String[] args) {

        format();

    }

    private static void format() {

        // 为正数或者负数添加符号
        System.out.println(String.format("%+d",15));        //+15
        System.out.println(String.format("%+d",-15));       //-15

        // 左对齐
        System.out.println(String.format("%-5d",15));       //{15   }
        System.out.println(String.format("%-4d",15));       //{15  }

        // 右对齐
        System.out.println(String.format("% 5d",15));       //{   15}
        System.out.println(String.format("% 5d",5));        //{    5}
        System.out.println(String.format("% 4d",15));       //{  15}
        System.out.println(String.format("% 4d",5));        //{   5}

        // 数字前面补0
        System.out.println(String.format("%02d", 32));      //32
        System.out.println(String.format("%03d", 32));      //032
        System.out.println(String.format("%04d", 32));      //0032

        // 以“,”对数字分组
        // %后面可以跟五个部分，但是只有类型部分是必须写的，如上句中的f即为单精度浮点型，还有四个部分按顺序，分别是可以指定参数的数字（有超过两个参数以上时），特定的类型（如上句中的“,”，或者给输出加上正负号），规定最小字符数（如上面的“6”），“.”符号加上精确度。
        System.out.println(String.format("%,f", 9999.99));      //9,999.990000
        System.out.println(String.format("%,.2f", 9999.99));    //9,999.99

        System.out.println(String.format("%,6.1f",2223223.155));//2,223,223.2
        System.out.println(String.format("%,.1f",3223.12));     //3,223.1
        System.out.println(String.format("%,.2f",3223.155));    //3,223.16

        System.out.println(String.format("%,6.2f", 9999999.666));//9,999,999.67
        System.out.println(String.format("%,6.2f", 9999999.605));//9,999,999.61
        System.out.println(String.format("%,6.2f", 9999999.604));//9,999,999.60
        System.out.println(String.format("%,6.2f", 9999999.603));//9,999,999.60

        System.out.println(String.format("%,5.2f", 9999999.666));//9,999,999.67
        System.out.println(String.format("%,5.2f", 9999999.605));//9,999,999.61
        System.out.println(String.format("%,5.2f", 9999999.604));//9,999,999.60
        System.out.println(String.format("%,5.2f", 9999999.603));//9,999,999.60

        System.out.println(String.format("%,4.2f", 9999999.666));//9,999,999.67
        System.out.println(String.format("%,4.2f", 9999999.605));//9,999,999.61
        System.out.println(String.format("%,4.2f", 9999999.604));//9,999,999.60
        System.out.println(String.format("%,4.2f", 9999999.603));//9,999,999.60

    }
}
