package com.gfg.basic.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SeriesGP {

	public static void main(String[] args) throws Exception{
		BufferedReader	br	=	new BufferedReader(new InputStreamReader(System.in));
//		int testCase	=	Integer.parseInt(br.readLine());
		String s	=	br.readLine();
		String s1	=	br.readLine();
		System.out.println(remAnagrams(s, s1));
//		while(testCase>0) {
//			String []firstLine	=	br.readLine().split(" ");
//			int firstTerm	=	Integer.parseInt(firstLine[0]);
//			int secondTerm	=	Integer.parseInt(firstLine[1]);
//			
//			int r	=	Math.floorDiv(secondTerm, firstTerm);
//			
//			int n	=	Integer.parseInt(br.readLine());
//			
//			Double nthTerm	=	firstTerm*Math.pow(r, n-1);
//			System.out.println(nthTerm.intValue());
//			testCase--;
//		}
	}
	
	public static int remAnagrams(String s, String s1) {
		int[] sArr = new int[26];
		int[] s1Arr = new int[26];

		for (int i = 0; i < 26; i++) {
			sArr[i] = 0;
			s1Arr[i] = 0;
		}
		for (int i = 0; i < s.length(); i++) {
			sArr[s.charAt(i) - 97]++;
		}
		for (int i = 0; i < s1.length(); i++) {
			s1Arr[s1.charAt(i) - 97]++;
		}
		
		int minChars = 0;
		for (int i = 0; i < 26; i++) {
			if (sArr[i] != s1Arr[i]) {
				minChars += Math.abs(sArr[i] - s1Arr[i]);
			}
		}
		return minChars;
 }
	
	
}
