package com.gfg.basic.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Date 22nd September 2018
public class SearchingANumber {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		while (testCase > 0) {
			String[] firstLine = br.readLine().split(" ");
			int n = Integer.parseInt(firstLine[0]);
			int k = Integer.parseInt(firstLine[1]);
			String[] secondLine = br.readLine().split(" ");
			boolean ifPresent	=	false;
			for (int i = 0; i < n; i++) {
				if (Integer.parseInt(secondLine[i]) == k) {
					System.out.println(i + 1);
					ifPresent	=	true;
					break;
				}
			}
			
			if(!ifPresent) {
				System.out.println(-1);
			}
			testCase--;
		}

	}
}
