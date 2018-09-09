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
		System.out.println(binarySearchGfg(arr, searchEle, 0, size-1));
	
		
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
	
}
