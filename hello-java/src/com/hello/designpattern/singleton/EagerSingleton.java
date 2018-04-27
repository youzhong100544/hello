package com.hello.designpattern.singleton;

public class EagerSingleton {
	// jvm保证在任何线程访问uniqueInstance静态变量之前一定先创建了此实例	
	private static EagerSingleton uniqueInstance = new EagerSingleton();

	// 私有的默认构造子，保证外界无法直接实例化	
	private EagerSingleton() { }

	// 提供全局访问点获取唯一的实例	
	public static EagerSingleton getInstance() {	
		return uniqueInstance;	
	}
}
