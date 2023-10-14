package com.example.demo.java8;

public class MethodReferenceDemo {
	public static void main(String[] args) {

		// Use Method reference to call Functional Interface method.
		FunctionalInterfaceDemo demo = Test::testImplementation;
		demo.singleAbstractMethod();

		// Using Lambda Expression to implement Functional interface method
		FunctionalInterfaceDemo demo1 = () -> System.out.println("This is lambda implementation method");
		demo1.singleAbstractMethod();

	}

}

class Test {
	public static void testImplementation() {
		System.out.println("This is test implementation method");
	}
}
