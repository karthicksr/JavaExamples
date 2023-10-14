package com.example.demo.java8;

@FunctionalInterface
public interface FunctionalInterfaceDemo {

	public void singleAbstractMethod();

	default void defaultMethod1() {
		System.out.println("This is default method1");
	}

	default void defaultMethod2() {
		System.out.println("This is default method2");
	}
}
