package com.example.demo.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.demo.entity.Students;

public class ComparatorInterfaceDemo {

	public static void main(String[] args) {
		List<Students> students = new ArrayList<>();
		students.add(new Students(101, "Karthick", 33));
		students.add(new Students(102, "Lakshmi", 30));
		students.add(new Students(103, "Deeksha", 4));
		students.add(new Students(104, "Radha", 60));
		
		//Comparaing students list without Null values 
		System.out.println("-------------------------------------Comparing by name ");
		Comparator<Students> comparator = Comparator.comparing(Students::getName);
		Collections.sort(students, comparator);

		for (Students student : students) {
			System.out.println(student.toString());
		}
		System.out.println("-------------------------------------Comparing by name with null values");
		//Comparing students list with null values also
		students.add(new Students(105, null, 10));
		Comparator<Students> comparator1=Comparator.comparing(Students::getName, Comparator.nullsFirst(String::compareTo));
		Collections.sort(students, comparator1);
		for (Students student : students) {
			System.out.println(student.toString());
		}
		System.out.println("-------------------------------------Multiple elements Comparator");
		//Comparing by multiple elements
		Comparator<Students> groupComparator=Comparator.comparing(Students::getName, Comparator.nullsLast(String::compareTo)).thenComparing(Comparator.comparingInt(Students::getAge));
		Collections.sort(students, groupComparator);
		for (Students student : students) {
			System.out.println(student.toString());
		}
		System.out.println("-------------------------------------Multiple elements Comparator with stream sorted method");
		//Comparing by multiple elements and use stream.sorted method to sort
		Comparator<Students> groupStreamComparator=Comparator.comparing(Students::getName, Comparator.nullsLast(String::compareTo)).thenComparing(Comparator.comparingInt(Students::getAge));
		students.stream().sorted(groupStreamComparator).forEach(System.out::print);
		Collections.sort(students, groupComparator);
		for (Students student : students) {
			System.out.println(student.toString());
		}
		System.out.println("------------------------------------- Reverse Order");
		Comparator<Students> reverseComparator=groupComparator.reversed();
		Collections.sort(students, reverseComparator);
		for (Students student : students) {
			System.out.println(student.toString());
		}
	}

}
