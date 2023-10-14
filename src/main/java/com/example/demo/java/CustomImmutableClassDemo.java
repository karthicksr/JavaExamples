package com.example.demo.java;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.entity.ImmutableStudent;

public class CustomImmutableClassDemo {

	public static void main(String args[]) {
		String name = "karthick";
		int regNo = 100;
		Map<String, String> map = new HashMap<>();

		map.put("1", "first");
		map.put("2", "second");

		ImmutableStudent s = new ImmutableStudent(name, regNo, map);

		// Calling the above methods 1,2,3 of class1
		// inside main() method in class2 and
		// executing the print statement over them
		System.out.println(s.getName());
		System.out.println(s.getRegNo());
		System.out.println(s.getMetadata());

		map.put("3", "third");
		// Remains unchanged due to deep copy in constructor
		System.out.println(s.getMetadata());
		s.getMetadata().put("4", "fourth");
		// Remains unchanged due to deep copy in getter
		System.out.println(s.getMetadata());
	}
}
