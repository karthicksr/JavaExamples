package com.example.demo.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.demo.entity.Student;

public class ComparableInterfaceDemo {

	public static void main(String args[]) {
		List<Student> students = new ArrayList<>();
		students.add(new Student(101, "Karthick", 33));
		students.add(new Student(102, "Lakshmi", 30));
		students.add(new Student(103, "Deeksha", 4));
		students.add(new Student(104, "Radha", 60));

		// Sort the elements in Student object
		Collections.sort(students);

		for (Student student : students) {
			System.out.println(student.toString());
		}
		System.out.println("Sorting using stream sorted method");
		students.stream().sorted().forEach(System.out::println);
	}
}
