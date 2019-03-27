package com.hello;

public class MainTest {

	public static void main(String[] args) {
		test_2();

	}

	public static void test_0() {
		String s = "1";
		System.out.println("s=" + s); // s=1

		int a = 9;
		System.out.println("a=" + a++);// a=9
		System.out.println("a=" + ++a);// a=11
		a = 9;
		System.out.println("a=" + ++a);// a=10


		int b = 9;
		b++;
		System.out.println("b=" + b);// b=10

		int i = 1;
		test_1(i);
		System.out.println("i=" + i);// i=1

	}

	public static void test_1(int a) {
		a = 10;

	}

	public static void test_2() {
		int a = 10;

		System.out.println("a > 10 : " + (a > 10));// false
		System.out.println("a < 10 : " + (a < 10));// false
		System.out.println("a = 10 : " + (a == 10));// true

	}




}
