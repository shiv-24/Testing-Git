package com.design.patterns.bulderpattern;

public class BuilderPatternDriverApplication {

	public static void main(String[] args) {
		MealBuilder build	=	new MealBuilder();
		Meal vegMeal	=	build.prepareVegBurger();
		Meal nonVegMeal	=	build.prepareNonVegBurger();
		
		System.out.println("Veggieee");
		vegMeal.showItems();
		
		System.out.println("Non Vegg");
		nonVegMeal.showItems();
	}
}
