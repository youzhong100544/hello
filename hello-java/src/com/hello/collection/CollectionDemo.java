package com.hello.collection;

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

public class CollectionDemo {
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
		List<String> al = new ArrayList<String>();
        List<String> ll = new LinkedList<String>();
        List<String> v = new Vector<String>();
        
        
        Set<String> hs = new HashSet<String>();
        Set<String> ts = new TreeSet<String>();
        
        Map<String, String> hm = new HashMap<String, String>();
        Map<String, String> tm = new TreeMap<String, String>();
        
        
	}
}
