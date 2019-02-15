package com.coding.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KadanesAlgo {

	//O(n^2)
	 public static int maxSumSubArray(int []a, int n) {
		 
		 int answer=Integer.MIN_VALUE;
		 
		 	for(int i=0;i<n;i++) {
		 		int sum=a[i];
		 		for(int j=i+1;j<n;j++) {
		 			sum+=a[j];
		 			if(answer<sum) {
		 				answer=sum;
		 			}
		 		}
		 	}
		 	
		 return answer;
		 
	 }
	 
	 //O(n)
	 
	 public static int kadanesAlgo(int a[],int n) {
		 
		 int cur_max	=	0, max_til_end=0;
		 
		 for(int i=0;i<n;i++) {
			 max_til_end+=a[i];
			 
			 if(max_til_end<0) {
				 max_til_end=0;
			 }
			 if(cur_max<max_til_end) {
				 cur_max=max_til_end;
			 }
		 }
		 
		 return cur_max;
		 
	 }
	 
	 public static void main(String[] args) throws Exception{
		
		 BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		 
		 int n	=	Integer.parseInt(br.readLine());
		 
		 String [] input	=	br.readLine().split(" ");
		 
		 int [] values	=	new int[n];
		 
		 for(int i=0;i<n;i++) {
			 values[i]=Integer.parseInt(input[i]);
		 }
				 
//		 System.out.println(maxSumSubArray(values, n));
		 System.out.println(kadanesAlgo(values, n));
	}
	
}
