package com.example.demo.java8;

public class StaticMethodDemoImpl implements StaticMethodDemo {

	
	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}

	public static void main(String args[]) {
		StaticMethodDemoImpl obj = new StaticMethodDemoImpl();
		obj.print("");
		obj.isNull("abc");
	}
}
