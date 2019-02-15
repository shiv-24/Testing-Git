package com.coding.sort;

public class PancakeSorting {

	
	public static void main(String[] args) {
		int a[]	=	{3,1,2,5,4};
		sort(a,5);
		for(int i=0;i<5;i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void sort(int []a,int n) {
		
		int min_index	=-1;
		
		int len	=	n-1;
		for(int i=0;i<n;i++) {
			int min	=	Integer.MAX_VALUE;	
			for(int j=0;j<=len;j++) {
				if(min>a[j]) {
					min	=	a[j];
					min_index	=	j;
				}
			 }
			flip(a,min_index);
			flip(a,len);
			len--;
		}
		
		flip(a,n-1);
	}
	
	static void flip(int []arr,int index) {
		
		int start	=0;
		int end	=	index;
		while(start<end) {
			int temp	=	arr[start];
			arr[start]	=	arr[end];
			arr[end]	=	temp;
			start++;
			end--;
			
		}
	}
}
