package com.design.patterns.bulderpattern;

import java.util.ArrayList;
import java.util.List;

public class Meal {

	private List<Items> items	=	new ArrayList<Items>();
	
	public void addMeal(Items item) {
		items.add(item);
	}
	
	public float getCost() {
		float cost	=	0f;
		
		for(Items item:items) {
			cost+=item.price();
		}
		return cost;
	}
	
	public void showItems() {
		for(Items item:items) {
			System.out.println(item.name());
			System.out.println(item.price());
			System.out.println(item.packing().pack());
			
		}
	}
}
