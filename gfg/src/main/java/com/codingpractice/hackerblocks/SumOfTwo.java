package com.codingpractice.hackerblocks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SumOfTwo {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());

		List<Integer> x = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			x.add(Integer.parseInt(br.readLine()));

		}

		int sum = Integer.parseInt(br.readLine());

		SumOfTwo classObj = new SumOfTwo();
		List<Map<Integer, Integer>> answer = classObj.sumOfTwo(x, size, sum);

		answer.forEach(pair -> {

			Set<Entry<Integer, Integer>> entrySet = pair.entrySet();
			Iterator<Entry<Integer, Integer>> ite = entrySet.iterator();

			while (ite.hasNext()) {
				Entry<Integer, Integer> ele = ite.next();
				System.out.println(ele.getKey() + " and " + ele.getValue());
			}

		});
		// classObj.sumOfTwo2(x, size, sum);;
	}

	private void sumOfTwo2(List<Integer> inputList, int size, int sum) {

		Collections.sort(inputList);

		for (int i = 0, j = size - 1; i < j;) {
			int a = inputList.get(i);
			int b = inputList.get(j);
			if ((a + b) == sum) {
				System.out.println(a + " and " + b);
				i++;
				j--;
			} else if ((a + b) < sum) {
				i++;
			} else {
				j--;
			}
		}
	}

	private List<Map<Integer, Integer>> sumOfTwo(List<Integer> inputList, int size, int sum) {
		List<Map<Integer, Integer>> answer = new ArrayList<>();
		Set<Integer> pair = new HashSet<>();
		Map<Integer, Integer> finalPair = new LinkedHashMap<>();

		Iterator<Integer> ite = inputList.iterator();
		while (ite.hasNext()) {
			Integer currNumber = ite.next();
			Integer diff = sum - currNumber;
			if (!pair.contains(diff)) {
				pair.add(currNumber);
			} else {
				finalPair.put(diff, currNumber);
			}
		}

		answer.add(finalPair);
		return answer;
	}
}
