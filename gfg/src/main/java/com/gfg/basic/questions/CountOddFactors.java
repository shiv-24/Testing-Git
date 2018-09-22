package com.gfg.basic.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Date 22nd September 2018
public class CountOddFactors {

	public static void main(String[] args) throws Exception{
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		int testCase	= Integer.parseInt(br.readLine());
		
		while(testCase>0) {
			int	n =	Integer.parseInt(br.readLine());
			Double answer	=	Math.sqrt(n);
			System.out.println(answer.intValue());
			testCase--;
		}
	}
	
	// Function will return the number of odd factors for the range rather than 1 to N; 
	private int oddFactorsForRange(int lowerRange, int upperRange) {
		
		Double upperRangeSqrt	=	Math.sqrt(upperRange);
		Double lowerRangeSqrt	=	Math.sqrt(lowerRange-1);
		
		return upperRangeSqrt.intValue()-lowerRangeSqrt.intValue();
	}
}
