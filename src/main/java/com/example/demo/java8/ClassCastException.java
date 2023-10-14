package com.example.demo.java8;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassCastException {
	
	public static int getDefaultCapacity(ArrayList<?> arrayList) throws Exception {

        if (arrayList == null) {
            return 0;
        }

        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);

        return ((Object[]) field.get(arrayList)).length;
    }
	
	public static void main(String[] args) throws Exception {

		String p1 = new String("John");
		String p2 = new String("Snow");
		String[] strArray = new String[] { p1, p2 };
		//ArrayList<String> strList = (ArrayList<String>) Arrays.asList(strArray);
		// To fix the ClassCastException at above line, modify the code as:
		 List<String> strList = Arrays.asList(strArray);
		System.out.println("String list: " + strList);
		
		System.out.println("default array list size -->"+ClassCastException.getDefaultCapacity(new ArrayList<>()));
		
		
		

	}
}
