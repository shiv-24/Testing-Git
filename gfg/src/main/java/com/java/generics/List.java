package com.java.generics;

import java.util.Arrays;
import java.util.function.Consumer;

public class List<T> {

	// private T x;
	//
	// public T get() {
	// return x;
	// }
	//
	// public void set(T x) {
	// this.x = x;
	// }
	//
	// public double add(T a) {
	// return this.x.doubleValue()+a.doubleValue();
	// }

	private Object x[];
	private int size = 0;
	private static final int DEFAULT_SIZE = 10;

	public List() {
		x = new Object[DEFAULT_SIZE];
	}

	public int size() {
		return size;
	}

	public void add(T obj) {
		if (size == x.length) {
			ensureCapacity();
		}
		x[size++] = obj;

	}

	private void ensureCapacity() {
		int newSize = 2 * size;
		x = Arrays.copyOf(x, newSize);
	}

	public T getEle(int index) {
		if (x.length > index) {
			return (T) x[index];
		} else {
			return null;
		}
	}
	
	public <U> void addAll(List<? extends T> allList) {
		for(int i=0;i<allList.size;i++) {
			this.add(allList.getEle(i));
		}
		return;
		
	}

	public void forEach(Consumer<T> name) {
		
		
	}
}
