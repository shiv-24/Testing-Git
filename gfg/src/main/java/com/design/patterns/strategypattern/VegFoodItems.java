package com.design.patterns.strategypattern;

import java.util.Map;

import com.java.generics.List;
import com.java.generics.Pair;

public class VegFoodItems implements FoodPackingStrategy {

	private List<Pair<String, Integer>> foodItems;

	@Override
	public void addFoodItemsWithPrice(List<Pair<String, Integer>> foodItems) {

		this.foodItems = foodItems;
	}

	@Override
	public int getBill() {
		int totalBill = 0;
		Calculator cal = new Calculator();
		cal.setStrategy(new Add());
		if (foodItems.size() != 0) {

			for (int i = 0; i < foodItems.size(); i++) {
				totalBill = cal.execute(totalBill, foodItems.getEle(i).getB());
			}
		}
		return totalBill;
	}

}
