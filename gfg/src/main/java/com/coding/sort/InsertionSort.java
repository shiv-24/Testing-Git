package com.coding.sort;

public class InsertionSort {

	public static void main(String[] args) {
		int a[] = { 12, 11, 13, 5, 6 };
		sort(a, 5);
		for (int i = 0; i < 5; i++) {
			System.out.println(a[i]);
		}
	}

	static void sort(int a[], int n) {

		for (int i = 1; i < n; i++) {

			int val = a[i];
			int j = i - 1;

			while (j >= 0 && a[j] > val) {
				a[j + 1] = a[j];
				j -= 1;
			}
			a[j + 1] = val;
		}
	}
}
