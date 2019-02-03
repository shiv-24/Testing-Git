package com.coding.dp;

import java.io.InputStreamReader;
import java.util.Scanner;

public class CatlanNumber {

	
	public int fact(int n) {
		int answer[]	=	new int [n+1];
		
		answer[0]=1;
		
		for(int i=1;i<=n;i++) {
			answer[i]=i*answer[i-1];
		}
		
		return answer[n];
	}
	
	public static void main(String[] args) {
		CatlanNumber obj	=	new CatlanNumber();  
				
		Scanner sc	=	new Scanner(new InputStreamReader(System.in));
		
		int n	=	sc.nextInt();
		int n1	=	n+1;
		int n1Fact	=	obj.fact(n1);
		int n2Fact	=	obj.fact(2*n);
		int nFact	=	n1Fact/n1;
		
		int deno	=	n1Fact*nFact;
		n2Fact/=deno;
		System.out.println(n2Fact);
		
	}
}
