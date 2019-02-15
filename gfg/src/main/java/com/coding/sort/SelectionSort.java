package com.coding.sort;

public class SelectionSort {

	
	public static void main(String[] args) {
		
		int a[]	=	{12, 11, 13, 5, 6};
		sortArr(a,5);
		
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		
	}
	
	public static void sortArr(int a[],int n) {
		
		int min	=Integer.MAX_VALUE;
		int index	=-1;
		for(int i=0;i<n;i++) {
			min	=	a[i];
			index	=i;
			for(int j=i+1;j<n;j++) {
				if(a[j]<min) {
					min	=	a[j];
					index	=j;
				}
			}
			int temp	=	a[i];
			a[i]	=	min;
			a[index]=	temp;
		}
	}
}
