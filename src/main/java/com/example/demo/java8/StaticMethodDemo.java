package com.example.demo.java8;

public interface StaticMethodDemo {
	default void print(String str) {
		if (!isNull(str))
			System.out.println("MyData Print::" + str);
	}

	//try to change below method from static to default. 
	static boolean isNull(String str) {
		System.out.println("Interface Null Check");

		return str == null ? true : "".equals(str) ? true : false;
	}
}
