package com.design.patterns.strategypattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.java.generics.List;
import com.java.generics.Pair;

public class ShivamCafe {

	private static Map<String, Integer> vegOptions;
	private static Map<String, Integer> nonVegOptions;

	static {
		vegOptions = new LinkedHashMap<>();
		nonVegOptions = new LinkedHashMap<>();

		vegOptions.put("Dal", 5);
		vegOptions.put("Roti", 1);
		vegOptions.put("Rice", 3);
		vegOptions.put("Kheer", 4);

		nonVegOptions.put("Chicken", 7);
		nonVegOptions.put("Pork", 3);
		nonVegOptions.put("Pork Rice", 4);
		nonVegOptions.put("Beef Pie", 5);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println("Welcome to the cafe" + "\n" + "You have Options in Veg and Non-Veg");

		Map<Integer, String> itemsList = new LinkedHashMap<>();
		List<Pair<String, Integer>> vegList = new List<Pair<String, Integer>>();
		List<Pair<String, Integer>> nonVegList = new List<Pair<String, Integer>>();

		Iterator<String> vegIte = vegOptions.keySet().iterator();
		Iterator<String> nonVegIte = nonVegOptions.keySet().iterator();

		int i = 1;
		System.out.println("Veg Options");
		while (vegIte.hasNext()) {
			String key = vegIte.next();
			System.out.println(i + " : " + key + " : " + vegOptions.get(key));
			itemsList.put(i, key);
			i++;
		}
		System.out.println("Non Veg Options");
		while (nonVegIte.hasNext()) {
			String key = nonVegIte.next();
			System.out.println(i + " : " + key + " : " + 2 * nonVegOptions.get(key));
			itemsList.put(i, key);
			i++;
		}

		System.out.println("Enter Your Choices and Enter -1 to End");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choices =0;
		Pair<String, Integer> foodPair;
		// br.readLine();
		do {
			choices = Integer.parseInt(br.readLine());
			if (choices == -1) {
				break;
			}
			String food = itemsList.get(choices);
			if (food != null) {
				if (vegOptions.containsKey(food)) {
					foodPair = new Pair<String, Integer>(food, vegOptions.get(food));
					vegList.add(foodPair);
				} else {
					foodPair = new Pair<String, Integer>(food, nonVegOptions.get(food));
					nonVegList.add(foodPair);
				}
			}
		} while (choices != -1);

		System.out.println("Your Final Order and The Estimated Bill wil be");

		BillBuilder bill = new BillBuilder();
		int totalBill = 0;
		if (vegList != null) {
			bill.setStrategy(new VegFoodItems());
			bill.addFoodItemsWithPrice(vegList);
			totalBill = bill.getBill();
		}

		if (nonVegList != null) {
			bill.setStrategy(new NonVegFoodItems());
			bill.addFoodItemsWithPrice(nonVegList);
			totalBill += bill.getBill();
		}

		for (int j = 0; j < vegList.size(); j++) {
			System.out.println(vegList.getEle(j));
		}
		for (int j = 0; j < nonVegList.size(); j++) {
			System.out.println(nonVegList.getEle(j).getA() + " : " + nonVegList.getEle(j).getB()*2);
		}
		System.out.println("Total Bill is " + totalBill);
	}

}
