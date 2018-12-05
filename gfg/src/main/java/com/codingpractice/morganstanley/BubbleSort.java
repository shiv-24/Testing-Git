package com.codingpractice.morganstanley;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BubbleSort {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		int arrSize	=	Integer.parseInt(br.readLine());
		String[] input	=	br.readLine().split(",");
		int []arr	=	new int[arrSize];
		for(int i=0;i<arrSize;i++) {
			arr[i]=	Integer.parseInt(input[i]);
		}
		long startTime	=	System.currentTimeMillis();
		bubbleSort(arr, input.length);
		long endTime	=	System.currentTimeMillis();
		
		System.out.println("Total Time For the firstTime"+(endTime-startTime));
		
		startTime		=	System.currentTimeMillis();
		optimizedBubbleSort(arr, input.length);
		endTime			=	System.currentTimeMillis();
		
		System.out.println("Total Time For the secondTime"+(endTime-startTime));
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	/**
	 * This will run with the complexity of O(N^2) Even if the array is sorted.
	 * @param arr
	 * @param size
	 */
	static void bubbleSort(int [] arr,int size) {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp	=	arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	
	/**
	 * This will run with the complexity of O(N^2) but in case if the array is sorted it'll run with O(N).
	 * @param arr
	 * @param size
	 */
	static void optimizedBubbleSort(int [] arr,int size) {
		boolean ifSwapped	=	false;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp	=	arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					ifSwapped	=	true;
				}
			}
			
			if(!ifSwapped) {
				break;
			}
		}
	}
}
