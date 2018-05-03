package com.hello;

import java.util.Comparator;
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
		//interface
		new java.util.Comparator(){

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
		};


		//interface
		new java.lang.Comparable(){

			@Override
			public int compareTo(Object o) {
				return 0;
			}
		};




	}
}
