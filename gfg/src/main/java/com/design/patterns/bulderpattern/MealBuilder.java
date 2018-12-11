package com.design.patterns.bulderpattern;

public class MealBuilder {

	public Meal prepareVegBurger() {
		Meal meal	=	new Meal();
		meal.addMeal(new VegBurger());
		meal.addMeal(new Coke());
		return meal;
	}
	
	public Meal prepareNonVegBurger() {
		Meal meal	=	new Meal();
		meal.addMeal(new NonVegBurger());
		meal.addMeal(new Pepsi());
		return meal;
	}
}
