package com.gfg.basic.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SeriesGP {

	public static void main(String[] args) throws Exception{
		BufferedReader	br	=	new BufferedReader(new InputStreamReader(System.in));
		int testCase	=	Integer.parseInt(br.readLine());
		
		while(testCase>0) {
			String []firstLine	=	br.readLine().split(" ");
			int firstTerm	=	Integer.parseInt(firstLine[0]);
			int secondTerm	=	Integer.parseInt(firstLine[1]);
			
			int r	=	Math.floorDiv(secondTerm, firstTerm);
			
			int n	=	Integer.parseInt(br.readLine());
			
			Double nthTerm	=	firstTerm*Math.pow(r, n-1);
			System.out.println(nthTerm.intValue());
			testCase--;
		}
	}
	
	
	
}
