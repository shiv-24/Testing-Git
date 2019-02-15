package com.pct.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

public class Advance4 {

	public static void main(String[] args) throws Exception{
		Map<Integer,List<Integer>> graph	=	new HashedMap();
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		
		Integer testCase	=	Integer.parseInt(br.readLine());
		
		for(int i=0;i<testCase;i++) {
			String [] input	=	br.readLine().split(" ");
			int[] numbers = new int[input.length];
			numbers[0]=	Integer.parseInt(input[0]);
			numbers[1]=	Integer.parseInt(input[1]);
			numbers[2]=	Integer.parseInt(input[2]);
			
			if(numbers[1]!=-1) {
				List<Integer> temp=	graph.get(numbers[0]);
				if(temp!=null) {
					temp.add(numbers[1]);
					graph.put(numbers[0], temp);
					
				}else {
					temp	=	new ArrayList<>();
					temp.add(numbers[1]);
					graph.put(numbers[0], temp);
				}
			}
			
			if(numbers[2]!=-1) {
				List<Integer> temp=	graph.get(numbers[2]);
				if(temp!=null) {
					temp.add(numbers[0]);
					graph.put(numbers[2], temp);
					
				}else {
					temp	=	new ArrayList<>();
					temp.add(numbers[0]);
					graph.put(numbers[2], temp);
				}
			}
		}
		
		
	}
	
	public static boolean ifCycle(Map<Integer,List<Integer>> graph) {
		boolean answer=	false;
		
		Map<Integer,Boolean> visitedMap	=	new HashedMap();
		
		Iterator<Integer> ite	=	graph.keySet().iterator();
		
		while(ite.hasNext()) {
			int start	=	ite.next();
			List<Integer> dependentNodes	=	graph.get(start);
			
		}
		
		return answer;
		
	}
	
//	public static 
}
