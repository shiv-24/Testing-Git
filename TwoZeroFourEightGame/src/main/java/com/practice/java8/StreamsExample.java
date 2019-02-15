package com.practice.java8;

import java.util.Arrays;
import java.util.List;

public class StreamsExample {

	
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Shivam", "Agg", 24), new Person("Shweta", "Chak", 25),
				new Person("Kirti", "Dhir", 24), new Person("Kunal", "Chau", 26), new Person("Hello", "World", 24));
		
		long startTime	=	System.currentTimeMillis(); 
		people.parallelStream().filter(p -> p.getFirstName().startsWith("C") || p.getLastName().startsWith("C"))
				.forEach(p -> System.out.println(p));
		;
		long endTime	=	System.currentTimeMillis();
		System.out.println("Total Time"+(endTime-startTime)/1000);
	}
}
