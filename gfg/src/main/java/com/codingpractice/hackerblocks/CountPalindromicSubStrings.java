package com.codingpractice.hackerblocks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountPalindromicSubStrings {

	public static void main(String[] args) throws Exception{
		 BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		 String input	=	br.readLine();
		 System.out.println(countPalindromicSubstring(input, input.length()));
	}
	
	static int countPalindromicSubstring(String input, int size) {
		int count	=0;
	
		for(int i=0;i<size;i++) {
			for(int j=i;j<size;j++) {
				if(ifPlaindrome(input.substring(i, j+1))) 
					count++;
			}
		}
		
		
		return count;
	}
	
	static boolean ifPlaindrome(String name) {
		boolean possible	=	true;
		
		for(int i=0,j=name.length()-1;i<j;i++,j--) {
			if(name.charAt(i)!=name.charAt(j)) {
				possible	=	false;
				break;
			}
		}
		
		return possible;
	}
}
