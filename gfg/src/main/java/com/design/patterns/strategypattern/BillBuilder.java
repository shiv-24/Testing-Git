package com.design.patterns.strategypattern;

import com.java.generics.List;
import com.java.generics.Pair;

public class BillBuilder {

	private FoodPackingStrategy strategy;

	public void setStrategy(FoodPackingStrategy strategy) {
		this.strategy = strategy;
	}

	public int getBill() {
		return strategy.getBill();
	}

	public void addFoodItemsWithPrice(List<Pair<String, Integer>> foodItems) {
		strategy.addFoodItemsWithPrice(foodItems);
	}

}
