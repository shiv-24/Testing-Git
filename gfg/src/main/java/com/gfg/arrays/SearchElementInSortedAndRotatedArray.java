package com.gfg.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.naming.InitialContext;
import javax.naming.ldap.InitialLdapContext;

public class SearchElementInSortedAndRotatedArray {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			arr[i]=Integer.parseInt(str[i]);
		}
		
		int searchEle	=	Integer.parseInt(br.readLine());
		
//		System.out.println(binarySearch(arr, searchEle, 0, size, size));
//		System.out.println(binarySearchGfg(arr, searchEle, 0, size-1));
		System.out.println(rotatedArraySearch(arr, searchEle, 0, size, size));
	
		
	}
	
	public static int binarySearch(int arr[], int x, int initialPoint, int finalPoint, int size) {

		int mid = initialPoint + (finalPoint - initialPoint) / 2;

		if (arr[mid] == x) {
			return mid;
		} else if (mid == 0 || mid == size - 1) {
			return -1;
		}

		if (arr[mid] < x) {

			return binarySearch(arr, x, mid + 1, finalPoint, size);
		} else {
			return binarySearch(arr, x, initialPoint, mid - 1, size);
		}

	}

	public static int binarySearchGfg(int arr[],int x,int initialPoint, int finalPoint) {
		
		if (finalPoint >= initialPoint) {
			int mid	=	initialPoint+ (finalPoint- initialPoint)/2;
			
			if(arr[mid]==x) {
				return mid;
			}
			
			if (arr[mid] < x) {

				return binarySearchGfg(arr, x, mid + 1, finalPoint);
			} else {
				return binarySearchGfg(arr, x, initialPoint, mid - 1);
			}
		}
		
		return -1;
	}
	
	public static int rotatedArraySearch(int arr[], int x, int initialPoint, int finalPoint,int size) {
		
		int influxPoint	=	rotatedArraySearchHelper(arr, initialPoint, finalPoint);
		
		if(influxPoint==-1) {
			return binarySearch(arr, x, initialPoint, finalPoint, size);
		}else {
			if(arr[influxPoint]>x) {
				return binarySearchGfg(arr, x, influxPoint+1, finalPoint-1);
			}else {
				return binarySearchGfg(arr, x, initialPoint, influxPoint-1);
			}
		}
	}
	
	public static int rotatedArraySearchHelper(int arr[], int initialPoint, int finalPoint) {
		
		if(finalPoint>=initialPoint) {
			
			int mid	=	initialPoint+(finalPoint-initialPoint)/2;
			
			if(arr[mid]>arr[mid+1]) {
				return mid;
			}else {
				return rotatedArraySearchHelper(arr, mid+1, finalPoint);
			}
		}
		
		return -1;
	}
}
