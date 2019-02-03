package com.coding.dp;

import java.io.InputStreamReader;
import java.util.Scanner;

public class UglyNumbers {

	public int getNthUglyNo(int n) {
		int answer[] = new int[n];

		answer[0] = 1;

		int index2 = 0, index3 = 0, index5 = 0;

		for (int i = 1; i < n; i++) {
			int val2 = answer[index2] * 2;
			int val3 = answer[index3] * 3;
			int val5 = answer[index5] * 5;

			int min = Math.min(val2, Math.min(val3, val5));

			answer[i] = min;

			if (min == val2) {
				index2 += 1;
			}
			if (min == val3) {
				index3 += 1;
			}

			if (min == val5) {
				index5 += 1;
			}
		}

		return answer[n - 1];
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();

		UglyNumbers obj = new UglyNumbers();

		System.out.println(obj.getNthUglyNo(n));
	}
}
