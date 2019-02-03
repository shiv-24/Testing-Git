package com.practice.java8;

public class Person {

	String firstName;
	String lastName;
	int age;
	
	public Person(String fName, String lName, int age) {
		this.firstName	=	fName;
		this.lastName	=	lName;
		this.age		=	age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.firstName+" "+ this.lastName+" "+ String.valueOf(this.age);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
