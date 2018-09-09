 package com.gfg.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotationOfAnArray {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		
		int size	=	Integer.parseInt(br.readLine());
		
		int [] arr	=	new int[size];
		String[] str	=	br.readLine().split(" ");
		for(int i=0;i<size;i++) {
			arr[i]=	Integer.parseInt(str[i]);
		}
		int rotationNumber	=	Integer.parseInt(br.readLine());
		
//		arr		=	rotateUsingSpaceN(arr, rotationNumber, size);
//		arr		=	rotateUsingSpaceD(arr, rotationNumber, size);
//		rotateWithoutSpace(arr, rotationNumber, size);
		cyclicalRotationOneByOne(arr, size);
		for(int i=0;i<size;i++)
		System.out.print(arr[i]+" ");
		
		System.out.println();
	}
	
	public static int[] rotateUsingSpaceN(int [] arr, int d, int size) {
		
		int []newArr	=	new int[size];
		int j=0;
		for(int i=d;i<size;i++) {
			newArr[j]	=	arr[i];
			j++;
		}
		
		for(int i=0;i<d;i++) {
			newArr[j]=arr[i];
			j++;
		}
		return newArr;
	}
	
	public static int[] rotateUsingSpaceD(int [] arr, int d, int size) {
		
		int []newArr	=	new int[d];
		int j=0;
		for(int i=0;i<d;i++) {
			newArr[j]=arr[i];
			j++;
		}
		int k=0;
		for(int i=d;i<size;i++) {
			arr[k]=arr[i];
			k++;
		}
		k=0;
		for(int i=size-d;i<size;i++) {
			arr[i]=newArr[k];
			k++;
		}
		
		return arr;
	}
	
	public static void rotateWithoutSpace(int [] arr, int d, int size) {
		
		for(int i=0;i<d;i++) {
			rotateWithoutSpaceHelper(arr, size);
		}
	}
	
	public static void rotateWithoutSpaceHelper(int []arr, int size) {
		int temp	=	arr[0];
		for(int i=0;i<size-1;i++) {
			arr[i]=arr[i+1];
		}
		arr[size-1]=temp;
	}
	
	public static void cyclicalRotationOneByOne(int []arr,int size) {
		
		int lastEle	=	arr[size-1];
		
		for(int i=size-1;i>0;i--) {
			arr[i]	=	arr[i-1];
		}
		arr[0]=lastEle;
	}
}
