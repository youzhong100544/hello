package com.hello.designpattern.singleton;

public class LazyInitHolderSingleton {
	private LazyInitHolderSingleton() { }

	private static class SingletonHolder {
		private static final LazyInitHolderSingleton INSTANCE = new LazyInitHolderSingleton();
	}

	public static LazyInitHolderSingleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
