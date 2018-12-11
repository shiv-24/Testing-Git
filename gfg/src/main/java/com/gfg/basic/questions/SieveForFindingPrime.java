package com.gfg.basic.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SieveForFindingPrime {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		System.out.println(calculateNumbers(number));
	}

	private static int calculateNumbers(int n) {
		int count = 0;

		boolean[] arr = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = true;
		}

		for (int p = 2; p * p <= n; p++) {

			if (arr[p]) {
				for (int i = p * 2; i <= n; i += p) {
					arr[i] = false;
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			if (arr[i])
				count++;
		}
		return count;
	}
}
