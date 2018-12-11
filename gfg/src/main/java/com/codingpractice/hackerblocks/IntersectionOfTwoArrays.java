package com.codingpractice.hackerblocks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) throws Exception {
		IntersectionOfTwoArrays classObject = new IntersectionOfTwoArrays();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		List<Integer> arrOne = new ArrayList<>();
		List<Integer> arrTwo = new ArrayList<>();

		String[] inputArr = br.readLine().split(" ");

		for (int i = 0; i < size; i++) {
			arrOne.add(Integer.parseInt(inputArr[i]));
		}

		inputArr = br.readLine().split(" ");

		for (int i = 0; i < size; i++) {
			arrTwo.add(Integer.parseInt(inputArr[i]));
		}

//		arrOne	=	classObject.printIntersection(arrOne, arrTwo);
		arrOne	=	classObject.printIntersection2(arrOne, arrTwo);
		
		Collections.sort(arrOne);
		
		arrOne.forEach(listItem->System.out.print(listItem+" "));
		
		int max	=	arrOne.stream().mapToInt(v->v).max().orElseThrow(NoSuchElementException::new);
		System.out.println(max);
	}
	
	
	private List<Integer> printIntersection2(List<Integer> arrOne, List<Integer> arrTwo){
		
		List<Integer> commonEleList	= new ArrayList<>();
		
		int max	=	Collections.max(arrOne);
		
		int maxArr[]	=	new int[max+1];
		
		for(int i=0;i<arrOne.size();i++) {
			maxArr[arrOne.get(i)]++;
		}
		
		for(int i=0;i<arrTwo.size();i++) {
			if(arrTwo.get(i)<=maxArr.length-1&& maxArr[arrTwo.get(i)]!=0) {
				commonEleList.add(arrTwo.get(i));
				maxArr[arrTwo.get(i)]--;
			}
		}
		
		return commonEleList;
	}
	
	/**
	 * Complexity is On(N^3)
	 * @param arrOne
	 * @param arrTwo
	 * @return
	 */
	private List<Integer> printIntersection(List<Integer> arrOne, List<Integer> arrTwo) {

		List<Integer> commonEleList	=	new ArrayList<>();
		for (int i = 0; i < arrOne.size(); i++) {
			int ele = arrOne.get(i);
			int eleIndex;
			if ((eleIndex=arrTwo.indexOf(ele))!=-1) {
				commonEleList.add(ele);
				arrTwo.remove(eleIndex);
			}
		}
		return commonEleList;
	}
}
