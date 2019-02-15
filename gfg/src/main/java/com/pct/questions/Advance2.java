package com.pct.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Advance2 {

	public static void main(String[] args) {
//
//		int N = 7;
//		List<Integer> input = Arrays.asList(38, 52, 145, 16, 179, 4);
//		List<Integer> hashTable = new ArrayList<>();
//		for (int i = 0; i < 6; i++) {
//			hashTable.add(Integer.MAX_VALUE);
//		}
//		Map<Integer, List<Integer>> answer = new LinkedHashMap<>();
//
//		for (int i = 0; i < input.size(); i++) {
//			List<Integer> temp = indexOfEle(input.get(i), hashTable, 7);
//			answer.put(i, temp);
//		}
//
//		Iterator<Integer> keys = answer.keySet().iterator();
//
//		while (keys.hasNext()) {
//			List<Integer> ans = answer.get(keys.next());
//			for (int i = 0; i < ans.size(); i++) {
//				System.out.print(ans.get(i) + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(insertHash(38,7));
		System.out.println(insertHash(52,7));
		System.out.println(insertHash(145,7));
		System.out.println(insertHash(16,7));
		System.out.println(insertHash(179,7));
		System.out.println(insertHash(4,7));
	}
	

	public static List<Integer> indexOfEle(int x, List<Integer> hashTable, int n) {

		List<Integer> answer = new ArrayList<>();

		int index = x % n;
		int originalNumber = x;
		int mod = 0;
		boolean ifFound = false;

		if (hashTable.get(index) == Integer.MAX_VALUE) {
			answer.add(index);
			hashTable.add(index, originalNumber);
		} else {
			answer.add(index);
			while (hashTable.get(index) != Integer.MAX_VALUE && x != 0) {
				mod = x % 10;
				x = x / 10;
				index = x % n;

				if (mod % 2 == 0) {
					index -= mod;
					if (index < 0) {
						index=x%n;
						continue;
					}
				} else {
					index += mod;
					if (index > hashTable.size() - 1) {
						index=x%n;
						continue;
					}
				}
				if (hashTable.get(index) == Integer.MAX_VALUE) {
					ifFound = true;
					answer.add(index);
					hashTable.add(index, originalNumber);
					break;
				} else {
					answer.add(index);
				}
			}

			if (ifFound != true) {
				if (mod % 2 == 0) {
					index -= 1;
					while (index >= 0) {
						if (hashTable.get(index) == Integer.MAX_VALUE) {
							answer.add(index);
							hashTable.add(index, originalNumber);
							break;
						} else {
							answer.add(index);
						}
						index -= 1;
					}
				} else {
					index += 1;
					while (index <= hashTable.size() - 1) {
						if (hashTable.get(index) == Integer.MAX_VALUE) {
							answer.add(index);
							hashTable.add(index, originalNumber);
							break;
						} else {
							answer.add(index);
						}
						index += 1;
					}
				}
			}

		}

		return answer;
	}

	static HashMap <Integer, Integer> ht = new HashMap<Integer, Integer>();
	public static String insertHash(int val,int N){
		String io = "";
		int i = val,direction = -1;
		int j = i%N;
		io += j + " ";
		if(ht.get(j) == null){
			ht.put(j, val);
			return io;
		}
		while(true){
			if((i%10)%2 == 1)
				direction = 1;
			else
				direction = -1;
			j = (j+direction*((i/10)%N) + N)%N;
			io += j + " ";
			if(ht.get(j) == null){
				ht.put(j, val);
				return io;
			}
			if(i<=10){
				while(true){
					j = (j+direction)%N;
					io += j + " ";
					if(ht.get(j) == null){
						ht.put(j, val);
						return io;
					}
				}
			}
			i = i/10;
		}
	}
}
