package com.gfg.basic.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Date 22nd September 2018
public class MaximumOccuringCharacter {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		int testCase	=	Integer.parseInt(br.readLine());
		
		while(testCase>0) {
			String inputString	=	br.readLine();
			int [] arr	=	new int[26];
			
			for(int i=0;i<26;i++) {
				arr[i]=0;
			}
			for(int i=0;i<inputString.length();i++) {
				arr[inputString.charAt(i)-97]++;
			}
			
			int index	=	0;
			int max		=	arr[0];
			
			for(int i=1;i<arr.length;i++) {
				if(max<arr[i]) {
					index	=	i;
					max		=	arr[i];
				}
			}
			System.out.println((char)(index+97));
			testCase--;
		}
	}
}
