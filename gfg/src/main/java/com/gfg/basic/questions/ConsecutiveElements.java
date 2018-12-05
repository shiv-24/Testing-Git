package com.gfg.basic.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//Date 22nd September 2018
public class ConsecutiveElements {

	public static void main(String[] args) throws Exception{
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		int testCase	=	Integer.parseInt(br.readLine());
		
		while(testCase>0) {
			String inputString	=	br.readLine();
			int i;
			for(i=0;i<inputString.length();) {
				int j=i+1;
				if(j<inputString.length()) {
					while(j<inputString.length()&&inputString.charAt(i)==inputString.charAt(j)) {
						j++;
					}
				}
				System.out.println(inputString.charAt(i));
				i=j;
			}
			System.out.println();
			testCase--;
		}
	}
}
