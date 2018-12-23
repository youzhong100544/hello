package com.hello.designpattern.singleton;

public class LazySingleton {
	
	private static LazySingleton uniqueInstance;	

	private LazySingleton() { }	

	public static synchronized LazySingleton getInstance() {	
		if (uniqueInstance == null)	
			uniqueInstance = new LazySingleton();	
		return uniqueInstance;	
	}	
} 
