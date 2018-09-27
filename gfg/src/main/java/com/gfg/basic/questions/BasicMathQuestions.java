package com.gfg.basic.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BasicMathQuestions {

	public static void main(String[] args) throws Exception{
		BufferedReader	br		=	new BufferedReader(new InputStreamReader(System.in));
		int n	=	Integer.parseInt(br.readLine());
		System.out.println(totalPrimeFactors(n));
	}
	
	private static int totalPrimeFactors(int n) {
		int count=0;
		for(int i=2;i<=n;i++) {
			if(ifPrime(i)) {
				if(n%i==0) {
					count++;
				}
			}
		}
		return count;
	}
	
	private static boolean ifPrime(int n) {
		
		boolean isPrime	=	true;
		
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) {
				isPrime	=	false;
				break;
			}
		}
		return isPrime;
	}
}
