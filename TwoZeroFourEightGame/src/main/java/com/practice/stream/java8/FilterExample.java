package com.practice.stream.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Shivam-30", "Shweta-26", "Greg-25", "Ryan-23", "Sam-24");
		// System.out.println(names.stream().findAny().get().length());

		// System.out.println(names.stream().allMatch(p->p.length()>=3));
		// Stream<String> fileredStream = names.stream().filter(p -> p.length() > 3);
		// fileredStream.filter(FilterExample::isNotShivam).forEach(name ->
		// System.out.println(name));
		// ;

		// names.stream().map(name->new
		// User(name,30)).forEach(user->System.out.println(user));
		int ageOfUserWithLengthGreaterThan4 = names.stream().filter(name -> name.length() > 4)
				.map(name -> new User(name, 30)).collect(Collectors.toList()).stream().mapToInt(user -> {
					return user.getAge();
				}).sum();
		System.out.println(ageOfUserWithLengthGreaterThan4);

		// User user = new User();
		names.stream().map(name -> {
			String[] arr = name.split("-");
			return new User(arr[0], Integer.parseInt(arr[1]));

		}).collect(Collectors.toList()).stream().mapToInt(User::getAge).sum();
		// names.stream().map(User::new);aF
	}

	public static boolean isNotShivam(String name) {
		return !name.equalsIgnoreCase("Shivam");
	}

	static class User {
		private String name;
		private Integer age;

		public User(String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		public User() {
			// TODO Auto-generated constructor stub
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name + " " + String.valueOf(age);
		}

	}
}
