package com.codingpractice.hackerblocks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Plaindrome {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		String name	=	br.readLine();
		if(ifPlaindrome(name)) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
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

