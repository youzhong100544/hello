package com.hello;

public class MainTest {

	public static void main(String[] args) {
		String s = "1";
		System.out.println("s=" + s);
		
		int a = 9;
		System.out.println("a=" + a++);//9
		System.out.println("a=" + ++a);//10
		int b = 9;
		b++;
		System.out.println("b=" + b);//9

		int i = 1;
		test_1(i);
		System.out.println("i=" + i);//


		String name = "qwertyui";
		String field = "tyu";
		System.out.println("name=" + name);

		if (name.contains(field)) {
			name = name.replace(field, "");
		}

		System.out.println("name=" + name);

	}

	public static void test_1(int a) {
		a = 10;

	}

}
