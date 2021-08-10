package com.yes.utilities;

public interface defo {

	default void m2() {
		System.out.println("default method");
	}
	
	public static int add(int a, int b) {
		return a+b;
	}
	
	
	public void m3();
	public void m4();
}
