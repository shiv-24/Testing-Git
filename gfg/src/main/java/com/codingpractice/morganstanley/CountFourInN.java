package com.codingpractice.morganstanley;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountFourInN {

	public static void main(String[] args) throws InputException {
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		try {
			int n	=	Integer.parseInt(br.readLine());
			int totalNumberOf4	=	0;
			for(int i=1;i<=n;i++) {
				totalNumberOf4+=count4(i);
			}
			System.out.println("Total Number of 4s "+totalNumberOf4);
		}catch (Exception e) {
			throw new InputException("In Custom Exception"+e.getMessage());
		}
	}
	
	public static int count4(int x) {
		int count=0;
		while(x!=0) {
			int rem	=	x%10;
			if(rem==4) {
				return 1;
			}
			x/=10;
		}
		return count;
	}
}
