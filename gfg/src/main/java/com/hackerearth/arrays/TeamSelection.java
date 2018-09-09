package com.hackerearth.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TeamSelection {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			arr1.add(Integer.parseInt(str[i]));

		}
		str = br.readLine().split(" ");

		for (int i = 0; i < size; i++) {
			arr2.add(Integer.parseInt(str[i]));

		}
		int totalTeams = 0;

		for (int i = 0; i < size; i++) {
			int striker = arr2.get(i);
			int defender1 = arr1.get(i);
			for (int j = 0; j < size; j++) {
				int defender2 = arr1.get(j);

				if (defender1 < defender2 && defender2 < striker) {
					totalTeams++;
				}
			}
		}
		System.out.println(totalTeams);

	}

}
