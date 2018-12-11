package com.design.patterns.strategypattern;

import com.java.generics.List;
import com.java.generics.Pair;

public interface FoodPackingStrategy {

	
	public void addFoodItemsWithPrice(List<Pair<String,Integer>> foodItems);
	
	public int getBill();
}
