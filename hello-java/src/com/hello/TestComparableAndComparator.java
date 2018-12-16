package com.hello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/*

Comparable与Comparator的区别
Comparable & Comparator 都是用来实现集合中元素的比较、排序的，
只是 Comparable 是在集合内部定义的方法实现的排序，Comparator 是在集合外部实现的排序，
所以，如想实现排序，就需要在集合外定义 Comparator 接口的方法或在集合内实现 Comparable 接口的方法。


有时在实现Comparator接口时，并没有实现equals方法，可程序并没有报错，原因是实现该接口的类也是Object类的子类，而Object类已经实现了equals方法

Comparable接口只提供了   int   compareTo(T   o)方法，也就是说假如我定义了一个Person类，这个类实现了   Comparable接口，
那么当我实例化Person类的person1后，我想比较person1和一个现有的Person对象person2的大小时，
我就可以这样来调用：
person1.comparTo(person2),通过返回值就可以判断了；

而此时如果你定义了一个   PersonComparator（实现了Comparator接口）的话，那你就可以这样：
PersonComparator   comparator=   new   PersonComparator();
comparator.compare(person1,person2);
 */
public class TestComparableAndComparator {
	public static void main(String[] args) {
		demoComparable();

		demoComparator();

	}


	public static void demoComparable(){
		System.out.println("-demoComparable-----------------------------------------");

		List<UserComparable> list = new ArrayList();

		UserComparable u1 = new UserComparable("xiaoming",12);
		UserComparable u2 = new UserComparable("xiaoming",11);
		UserComparable u3 = new UserComparable("xiaohong",12);
		UserComparable u4 = new UserComparable("qiang",12);

		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("------------------------------------------");

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("------------------------------------------");

	}

	public static void demoComparator(){
		System.out.println("-demoComparator-----------------------------------------");

		List<UserComparator> list = new ArrayList();

		UserComparator u1 = new UserComparator("xiaoming",12);
		UserComparator u2 = new UserComparator("xiaoming",11);
		UserComparator u3 = new UserComparator("xiaohong",12);
		UserComparator u4 = new UserComparator("qiang",12);

		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("------------------------------------------");

		Collections.sort(list, new UserComparator());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("------------------------------------------");

	}
}

/**
 * Comparable
 *
 * 		Comparable可以认为是一个内比较器，实现了Comparable接口的类有一个特点，就是这些类是可以和自己比较的，至于具体和另一个实现了Comparable接口的类如何比较，则依赖compareTo方法的实现，compareTo方法也被称为自然比较方法。
 * 		如果开发者add进入一个Collection的对象想要Collections的sort方法帮你自动进行排序的话，那么这个对象必须实现Comparable接口。compareTo方法的返回值是int，有三种情况：
 *
 * 			1、比较者大于被比较者（也就是compareTo方法里面的对象），那么返回正整数
 * 			2、比较者等于被比较者，那么返回0
 * 			3、比较者小于被比较者，那么返回负整数
 */
class DemoDefineComparable implements java.lang.Comparable {

	@Override
	public int compareTo(Object o) {
		return 0;
	}

}

/**
 * Comparator
 *
 * 		Comparator可以认为是是一个外比较器，个人认为有两种情况可以使用实现Comparator接口的方式：
 *
 * 			1、一个对象不支持自己和自己比较（没有实现Comparable接口），但是又想对两个对象进行比较
 * 			2、一个对象实现了Comparable接口，但是开发者认为compareTo方法中的比较方式并不是自己想要的那种比较方式
 *
 * 		Comparator接口里面有一个compare方法，方法有两个参数T o1和T o2，是泛型的表示方式，分别表示待比较的两个对象，方法返回值和Comparable接口一样是int，有三种情况：
 *
 * 			1、o1大于o2，返回正整数
 * 			2、o1等于o2，返回0
 * 			3、o1小于o3，返回负整数
 */
class DemoDefineComparator implements java.util.Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		return 0;
	}

	@Override
	public Comparator reversed() {
		return null;
	}

	@Override
	public Comparator thenComparing(Comparator other) {
		return null;
	}

	@Override
	public Comparator thenComparingInt(ToIntFunction keyExtractor) {
		return null;
	}

	@Override
	public Comparator thenComparingLong(ToLongFunction keyExtractor) {
		return null;
	}

	@Override
	public Comparator thenComparingDouble(ToDoubleFunction keyExtractor) {
		return null;
	}

	@Override
	public Comparator thenComparing(Function keyExtractor) {
		return null;
	}

	@Override
	public Comparator thenComparing(Function keyExtractor, Comparator keyComparator) {
		return null;
	}

}


class UserComparable implements Comparable<UserComparable> {

	private String name;
	private Integer age;

	public UserComparable(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserComparable{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	@Override
	public int compareTo(UserComparable another) {
		int i = name.compareTo(another.name); // 使用字符串的比较
		if(i == 0) { // 如果名字一样,比较年龄, 返回比较年龄结果
			return age - another.age;
		} else {
			return i; // 名字不一样, 返回比较名字的结果.
		}
	}
}

class UserComparator implements Comparator<UserComparator> {

	private String name;
	private Integer age;

	public UserComparator() {

	}

	public UserComparator(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserComparator{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	@Override
	public int compare(UserComparator one, UserComparator another) {
		int i = one.name.compareTo(another.name); // 使用字符串的比较
		if(i == 0) { // 如果名字一样,比较年龄,返回比较年龄结果
			return one.age - another.age;
		} else {
			return i; // 名字不一样, 返回比较名字的结果.
		}
	}


}