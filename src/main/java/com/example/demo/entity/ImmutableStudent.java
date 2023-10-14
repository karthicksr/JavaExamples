package com.example.demo.entity;

import java.util.HashMap;
import java.util.Map;

//An Immutable class
public final class ImmutableStudent {

	// Member attributes of final class - All member should be declared as private
	// only.
	private final String name;
	private final int regNo;
	private final Map<String, String> metadata;

	public ImmutableStudent(String name, int regNo, Map<String, String> metadata) {
		super();
		this.name = name;
		this.regNo = regNo;

		// this.metadata = metadata;

		// Creating Map object with reference to HashMap
		// Declaring object of string type
		Map<String, String> tempMap = new HashMap<>();
		// Iterating using for-each loop
		for (Map.Entry<String, String> entry : metadata.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		this.metadata = tempMap;
	}

	public String getName() {
		return name;
	}

	public int getRegNo() {
		return regNo;
	}

	public Map<String, String> getMetadata() {
		Map<String, String> tempMap = new HashMap<>();
		for (Map.Entry<String, String> entry : this.metadata.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		return tempMap;
	}

	
}
