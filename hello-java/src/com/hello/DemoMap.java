package com.hello;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class DemoMap {

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
        
        Map<String, String> hm = new HashMap<String, String>();
        Map<String, String> tm = new TreeMap<String, String>();
        
        Map<String, String> ht = new Hashtable<String, String>();
        
	}
}
