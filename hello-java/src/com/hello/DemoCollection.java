package com.hello;

import com.hello.clazz.Fruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class DemoCollection {

	/**
	 *  Collection、List、Set和Map都是接口（Interface），不是具体的类实现。
	 *  List lst = new ArrayList(); 
	 *  这是我们平常经常使用的创建一个新的List的语句，在这里， List是接口，ArrayList才是具体的类。

		常用集合类的继承结构如下：
		Iterable<--Collection<--List<--Vector
		Iterable<--Collection<--List<--ArrayList
		Iterable<--Collection<--List<--LinkedList
		Iterable<--Collection<--Set<--HashSet
		Iterable<--Collection<--Set<--HashSet<--LinkedHashSet
		Iterable<--Collection<--Set<--SortedSet<--TreeSet
		
		Map<--SortedMap<--TreeMap
		Map<--HashMap 
		Map<--Hashtable 
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * 为什么
		 *     对于java中的list来说，如果list中的元素是基本类型或者String类型，那么sout(list)是可以直接打印出元素的，
		 *     如果是对象类型，那么结果是XX@xxxx
		 *
		 *     public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable
		 *
		 *     public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>
		 *
		 *     public abstract class AbstractCollection<E> implements Collection<E>
		 *         public String toString() {
		 *             Iterator<E> it = iterator();
		 *             if (! it.hasNext())
		 *                 return "[]";
		 *
		 *             StringBuilder sb = new StringBuilder();
		 *             sb.append('[');
		 *             for (;;) {
		 *                 E e = it.next();
		 *                 sb.append(e == this ? "(this Collection)" : e);
		 *                 if (! it.hasNext())
		 *                     return sb.append(']').toString();
		 *                 sb.append(',').append(' ');
		 *             }
		 *     	   }
		 *
		 *     public class Object
		 *     	   public String toString() {
		 *             return getClass().getName() + "@" + Integer.toHexString(hashCode());
		 *         }
		 *
		 * */
		//test_1();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//test_2();

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		test_3();
        
        
	}

	public static void test_0() {
		List<String> al = new ArrayList<String>();
		List<String> ll = new LinkedList<String>();
		List<String> v = new Vector<String>();


		Set<String> hs = new HashSet<String>();
		Set<String> ts = new TreeSet<String>();
	}
	public static void test_1() {
		List<String> al = new ArrayList<String>();
		al.add("1");
		al.add("2");
		System.out.println("ArrayList = " + al);
		System.out.println("ArrayList.toString = " + al.toString());
		System.out.println();

		List<String> ll = new LinkedList<String>();
		ll.add("3");
		ll.add("4");
		System.out.println("LinkedList = " + ll);
		System.out.println("LinkedList.toString = " + ll.toString());
		System.out.println();

		List<String> v = new Vector<String>();
		v.add("5");
		v.add("6");
		System.out.println("Vector = " + v);
		System.out.println("Vector.toString = " + v.toString());
		System.out.println();


		/*
			ArrayList = [1, 2]
			ArrayList.toString = [1, 2]

			LinkedList = [3, 4]
			LinkedList.toString = [3, 4]

			Vector = [5, 6]
			Vector.toString = [5, 6]
		*/
	}

	public static void test_2() {
		Fruit apple = new Fruit("apple");
		Fruit banana = new Fruit("banana");
		List<Fruit> al = new ArrayList<Fruit>();
		al.add(apple);
		al.add(banana);
		System.out.println("ArrayList = " + al);
		System.out.println("ArrayList.toString = " + al.toString());
		System.out.println();

		List<Fruit> ll = new LinkedList<Fruit>();
		ll.add(apple);
		ll.add(banana);
		System.out.println("LinkedList = " + ll);
		System.out.println("LinkedList.toString = " + ll.toString());
		System.out.println();

		List<Fruit> v = new Vector<Fruit>();
		v.add(apple);
		v.add(banana);
		System.out.println("Vector = " + v);
		System.out.println("Vector.toString = " + v.toString());
		System.out.println();

		/*
			ArrayList = [com.hello.clazz.Fruit@1540e19d, com.hello.clazz.Fruit@677327b6]
			ArrayList.toString = [com.hello.clazz.Fruit@1540e19d, com.hello.clazz.Fruit@677327b6]

			LinkedList = [com.hello.clazz.Fruit@1540e19d, com.hello.clazz.Fruit@677327b6]
			LinkedList.toString = [com.hello.clazz.Fruit@1540e19d, com.hello.clazz.Fruit@677327b6]

			Vector = [com.hello.clazz.Fruit@1540e19d, com.hello.clazz.Fruit@677327b6]
			Vector.toString = [com.hello.clazz.Fruit@1540e19d, com.hello.clazz.Fruit@677327b6]
		*/
	}

	public static void test_3() {
		List<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(0,2);

		al.add(2,20);

		// al.add(4,20); // Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 4, Size: 3
		System.out.println("ArrayList = " + al);
		System.out.println("ArrayList.toString = " + al.toString());
		System.out.println();
	}
}
