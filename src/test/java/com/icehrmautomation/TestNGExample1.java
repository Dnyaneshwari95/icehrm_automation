package com.icehrmautomation;

import org.testng.annotations.Test;

public class TestNGExample1 {

	@Test
	public void add() {
		int a=10;
		int b=20;
		System.out.println("This is a addition method");
		System.out.println("addition of a and b is:"+(a+b));
	}
	
	@Test
	public void devide() {
		int a=10;
		int b=20;
		System.out.println("This is a devide method");
		System.out.println("addition of a and b is:"+(a/b));	
	}
	
	@Test
	public void sub() {
		int a=10;
		int b=20;
		System.out.println("This is a sub method");
		System.out.println("addition of a and b is:"+(a-b));	
	}
	
	@Test
	public void multiplication() {
		int a=10;
		int b=20;
		System.out.println("This is a devide method");
		System.out.println("addition of a and b is:"+(a*b));	
	}

}
