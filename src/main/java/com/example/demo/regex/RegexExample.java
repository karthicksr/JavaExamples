package com.example.demo.regex;

import java.util.regex.Pattern;

public class RegexExample {

	public static void main(String[] args) {
		System.out.println(Pattern.matches("[amn]", "abcd"));// false (not a or m or n)
		System.out.println(Pattern.matches("[amn]", "a"));// true (among a or m or n)
		System.out.println(Pattern.matches("[amn]", "ammmna"));// false (m and a comes more than once)
		System.out.println(Pattern.matches("[0-9]{4}\\s[0-9]{4}\\s", "1234	5678	"));
		System.out.println(Pattern.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}", "karthick@gmail.com"));
	}
}
