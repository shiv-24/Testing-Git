package com.gfg.basic.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GCDOfAnArray {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		int a	=	Integer.parseInt(br.readLine());
		int b	=	Integer.parseInt(br.readLine());
		
		System.out.println(gcd(a,b));
	}
	
	
	private static int gcd(int a, int b) {
		
		if(b==0) {
			return a;
		}else {
			return gcd(b,a%b);
		}
	} 
}
