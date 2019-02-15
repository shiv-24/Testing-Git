package com.practice.stream.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

	
	public static void main(String[] args) {
		List<User> users = Arrays.asList(new User("Shivam", 20, Arrays.asList("1", "2", "3")),
				new User("Kirti", 20, Arrays.asList("4", "5", "6", "7")),
				new User("Shweta", 21, Arrays.asList("8", "9")), new User("Shanu", 22, Arrays.asList("10")));

		users.stream().map(user -> user.getPhoneNumbers().stream())
				.flatMap(phoneNumber -> phoneNumber.filter(pNumber -> pNumber.equals("5"))).collect(Collectors.toList())
				.forEach(System.out::println);

	}

	static class User {
		private String name;
		private Integer age;
		private List<String> phoneNumbers;

		public List<String> getPhoneNumbers() {
			return phoneNumbers;
		}

		public void setPhoneNumbers(List<String> phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		}

		public User(String name, Integer age, List<String> phoneNumbers) {
			super();
			this.name = name;
			this.age = age;
			this.phoneNumbers = phoneNumbers;
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
