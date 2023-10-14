package com.example.demo.java8.iq;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.example.demo.entity.Employee;

public class SecondHighestSalary {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		Employee e1 = new Employee(1, "Karthick", 50000);
		Employee e2 = new Employee(2, "Priya", 45000);
		Employee e3 = new Employee(3, "Deeksha", 30000);
		Employee e4 = new Employee(4, "Lakshmi", 45000);
		Employee e5 = new Employee(5, "Radha", 20000);
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		employees.add(e5);

		System.out.println("2nd Highest Salary :" + employees.stream()
				.sorted(Comparator.comparingInt(Employee::getSalary).reversed()).skip(1).findFirst().get());

	}

}
