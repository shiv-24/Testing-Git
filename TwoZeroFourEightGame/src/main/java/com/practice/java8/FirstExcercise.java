package com.practice.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FirstExcercise {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("Shivam", "Agg", 24), new Person("Shweta", "Chak", 25),
				new Person("Kirti", "Dhir", 24), new Person("Kunal", "Chau", 26), new Person("Hello", "World", 24));

		Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

		PrintEle obj = (people1, condition,consumer) -> {
			for (int i = 0; i < people1.size(); i++) {
				if (condition.test(people1.get(i))) {
					consumer.accept(people1.get(i));
				}
			}
		};

		obj.print(people, p->true,p->System.out.println(p));
		System.out.println("-----------------------------------------------");
		obj.print(people, person1 -> person1.getLastName().startsWith("C"),p->System.out.println(p.getLastName()));
	}

	interface PrintEle {
		void print(List<Person> people, Predicate<Person> condition, Consumer<Person> consume);
	}

}
