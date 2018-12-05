package com.codingpractice.hackerblocks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AddTwoArrays {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		int arrSize1	=	Integer.parseInt(br.readLine());
		int [] arr1		=	new int[arrSize1];
		String[] strArr1	=	br.readLine().split(" ");
		
		for(int i=0;i<arrSize1;i++) {
			arr1[i]	=	Integer.parseInt(strArr1[i]);
		}
		
		int arrSize2	=	Integer.parseInt(br.readLine());
		int [] arr2		=	new int[arrSize2];
		String[] strArr2	=	br.readLine().split(" ");
		
		for(int i=0;i<arrSize2;i++) {
			arr2[i]	=	Integer.parseInt(strArr2[i]);
		}
		AddTwoArrays classObject	=	new AddTwoArrays();
		classObject.addArrays(arr1, arrSize1, arr2, arrSize2);
	}
	
	private void addArrays(int []arr1, int size1, int []arr2, int size2) {
		int i,j;
		int sum=0, carry	=0;
		List<Integer> finalSum	=	new ArrayList<>();
		for(i=size1-1,j=size2-1;i>=0 && j>=0;i--,j--) {
			
			sum	=	(arr1[i]+arr2[j]+carry);
			carry	=	sum/10;
			sum%=10;
			finalSum.add(sum);
		}
		
		if(i>=0) {
			for(;i>=0;i--) {
				sum	=	(arr1[i]+carry);
				carry	=	sum/10;
				sum%=10;
				finalSum.add(sum);	
			}
		}else {
			for(;j>=0;j--) {
				sum	=	(arr2[j]+carry);
				carry	=	sum/10;
				sum%=10;
				finalSum.add(sum);	
			}
		}
		if(carry!=0) {
			finalSum.add(carry);
		}
		for(i=finalSum.size()-1;i>=0;i--) {
			System.out.print(finalSum.get(i)+", ");
		}
		System.out.println("End");
	}
}
