package com.java.generics;

import java.util.Scanner;

public class PairDriver {

	// public static void main(String[] args) {
	// List<Pair<String, String>> namePairList = new List<>();
	// Pair<String, String> namePair = null;
	// System.out.println("Enter the total No of Students in class");
	// System.out.println();
	// Scanner sc = new Scanner(System.in);
	//
	// int x = sc.nextInt();
	// sc.nextLine();
	// for (int i = 0; i < x; i++) {
	// String inputName = sc.nextLine();
	// String[] name = inputName.split(" ");
	// namePair = new Pair<String, String>(name[0], name[1]);
	// namePairList.add(namePair);
	// }
	//
	// sc.close();
	//
	// System.out.println("Name of the Students in the class");
	//
	// for (int i = 0; i < namePairList.size(); i++) {
	//// System.out.println("First Name of the student is " +
	// namePairList.getEle(i).getA());
	//// System.out.println("Last Name of the student is " +
	// namePairList.getEle(i).getB());
	//
	// System.out.println(namePairList.getEle(i));
	// }
	//
	// }

//	public static void main(String[] args) {
//
//		// ComparablePair<Integer, Integer> pairToCompare = new ComparablePair<Integer,
//		// Integer>(2,3);
//		//
//		// ComparablePair<Integer, Integer> secondPair = new ComparablePair<Integer,
//		// Integer>(4,5);
//		//
//		// System.out.println(pairToCompare.compareTo(secondPair));
//
//		List<ComparablePair<Integer, String>> pairList = new List<ComparablePair<Integer, String>>();
//
//		pairList.add(new ComparablePair<Integer, String>(3, "trois"));
//		pairList.add(new ComparablePair<Integer, String>(4, "quatre"));
//		pairList.add(new ComparablePair<Integer, String>(1, "vn"));
//		pairList.add(new ComparablePair<Integer, String>(1, "one"));
//		pairList.add(new ComparablePair<Integer, String>(1, "one"));
//
//		ComparablePair<Integer, String> prevPair = null;
//		for (int i = 0; i < pairList.size(); i++) {
//			ComparablePair<Integer, String> pairToGet = pairList.getEle(i);
//			System.out.println(pairToGet);
//			if (prevPair != null) {
//				System.out.println(pairToGet.compareTo(prevPair));
//				
//			}
//			prevPair = new ComparablePair<Integer, String>(pairToGet.getA(), pairToGet.getB());
//		}
//
//	}
}
