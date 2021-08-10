package com.yes.utilities;

public class Test {

	public static void m5() {
		for (int i=0; i < 3; i++) {
			System.out.println("Another child thread");
		}
	}
	
	public void m6() {
		for (int i=0; i < 3; i++) {
			System.out.println("Another child thread with instance method");
		}
	}
	
	public static void sum(int x, int y) {
		System.out.println("Sum: "+(x+y));
	}
}
