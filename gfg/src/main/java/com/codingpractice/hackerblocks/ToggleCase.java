package com.codingpractice.hackerblocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ToggleCase {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//// String input = br.readLine();
		// String input2 = br.readLine();
		// int size = Integer.parseInt(input2);
		// input2 = br.readLine();
		// String [] arrStr = input2.split(" ");
		// int []arr = new int[size];
		//
		// for(int i=0;i<size;i++) {
		// arr[i]=Integer.parseInt(arrStr[i]);
		// }
		//// input2.
		////
		// int number = Integer.parseInt(br.readLine());
		// printToggle(input, input.length());
		// printOddEvenCharacter(input, input.length());
		// printDiffInAsciiCode(input, input.length());
		// printMaxFrequencyChar(input, input.length());
		// removeDuplicates(input, input.length());
		// System.out.println(getNthTriangle(4));
		// System.out.println(isArraySorted(arr, 0, size));
		// System.out.println(ifContained(arr, size, 0, number));
		// System.out.println(ifPalindrome("nitin", 0, 4));
		// System.out.println(sumOfDidgits(12234));
		// allIndices(arr, size, 0, number);
		// String answer = new String();
		// movex("axbxa", 5, 0,0,answer);
		// answer.substring()

		// System.out.println(acount("aaaaa", 5, 0, 3));
		// System.out.println(acountW("aaaaaaaa", 8, 0, 3));
		// char[] arr = new char[26];
		// for(int i=0;i<26;i++) {
		// arr[i] = (char)(i+97);
		// }

		Set<String> answer = new HashSet<>();
		char[] arr = new char[26];

		for (int i = 0; i < 26; i++) {
			arr[i] = (char) (i + 97);
		}
//		printRecCodes("2345", 4, answer, arr, 0);
//		List<String> strList = new ArrayList<>(answer);
//		Collections.sort(strList);
//		System.out.print("[");
//		// String answerStr = new String();
//		strList.forEach(s -> {
//
//			System.out.print(s + ",");
//		});
//		System.out.println("]");
		
		String newAns	=	new String();
		printCodes("1125", newAns);
		System.out.println(newAns);
	}

	public static void movex(String str, int length, int index, int count, String finalString) {
		if (index >= length) {
			for (int i = 0; i < count; i++) {
				finalString += "x";
			}
			System.out.println(finalString);
			return;
		}
		if (str.charAt(index) == 'x') {
			count++;
			movex(str, length, index + 1, count, finalString);
		} else {
			finalString += str.charAt(index);
			movex(str, length, index + 1, count, finalString);
		}

	}

	public static int acount(String str, int length, int first, int last) {
		if (last > length) {
			return 0;
		}
		if (str.substring(first, last).equals("aaa")) {
			return 1 + acount(str, length, first + 1, last + 1);
		} else {
			return acount(str, length, first + 1, last + 1);
		}
	}

	public static int acountW(String str, int length, int first, int last) {
		if (last > length) {
			return 0;
		}
		if (str.substring(first, last).equals("aaa")) {
			return 1 + acountW(str, length, first + 3, last + 3);
		} else {
			return acountW(str, length, first + 1, last + 1);
		}
	}

	public static String swap(String s, int i0, int i1) {
		String s1 = s.substring(0, i0);
		String s2 = s.substring(i0 + 1, i1);
		String s3 = s.substring(i1 + 1);
		return s1 + s.charAt(i1) + s2 + s.charAt(i0) + s3;
	}

	static void printToggle(String input, int size) {
		for (int i = 0; i < size; i++) {
			char c = input.charAt(i);
			if (c - 97 >= 0) {
				System.out.print((char) (c - 32));
			} else {
				System.out.print((char) (c + 32));
			}

		}
	}

	static void printOddEvenCharacter(String input, int size) {

		for (int i = 1; i <= size; i++) {
			char c = input.charAt(i - 1);

			if (i % 2 == 0) {
				System.out.print((char) (c - 1));
			} else {
				System.out.print((char) (c + 1));
			}

		}
	}

	static void printDiffInAsciiCode(String input, int size) {

		for (int i = 0; i < size - 1; i++) {
			char fi = input.charAt(i);
			char sec = input.charAt(i + 1);
			int diff = sec - fi;
			System.out.print(fi + String.valueOf(diff));
		}
		System.out.print(input.charAt(size - 1));
	}

	static void printMaxFrequencyChar(String input, int size) {

		int alpha[] = new int[26];
		int index = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < size; i++) {
			alpha[input.charAt(i) - 97]++;
		}

		for (int i = 0; i < 26; i++) {
			if (max < alpha[i]) {
				index = i;
				max = alpha[i];
			}
		}

		System.out.println((char) (index + 97));
	}

	static void removeDuplicates(String input, int size) {

		for (int i = 0; i < size - 1;) {
			char initialChar = input.charAt(i);
			while (i < size - 1 && input.charAt(i) == input.charAt(i + 1)) {
				i++;
			}
			System.out.print(initialChar);
			i++;
		}
	}

	static int getNthTriangle(int n) {

		if (n == 1) {
			return 1;
		} else {
			return n + getNthTriangle(n - 1);
		}
	}

	static boolean isArraySorted(int[] arr, int index, int size) {

		if (index >= size - 1) {
			return true;
		} else if (arr[index] > arr[index + 1]) {
			return false;
		} else {
			return isArraySorted(arr, index + 1, size);
		}
	}

	static boolean ifContained(int[] arr, int size, int index, int number) {

		if (index >= size) {
			return false;
		} else if (arr[index] == number) {
			return true;
		} else {
			return ifContained(arr, size, index + 1, number);
		}
	}

	static int firstIndex(int[] arr, int size, int index, int number) {

		if (index >= size) {
			return -1;
		} else if (arr[index] == number) {
			return index;
		} else {
			return firstIndex(arr, size, index + 1, number);
		}
	}

	static int lastIndex(int[] arr, int size, int index, int number) {

		if (index < 0) {
			return -1;
		} else if (arr[index] == number) {
			return index;
		} else {
			return lastIndex(arr, size, index - 1, number);
		}
	}

	static void allIndices(int[] arr, int size, int index, int number) {
		if (index >= size) {
			return;
		} else if (arr[index] == number) {
			System.out.print(index + " ");
			allIndices(arr, size, index + 1, number);
		} else {
			allIndices(arr, size, index + 1, number);
		}
	}

	static boolean ifPalindrome(String input, int fIndex, int lIndex) {

		if (fIndex >= lIndex) {
			return true;
		} else if (input.charAt(fIndex) != input.charAt(lIndex)) {
			return false;
		} else {
			return ifPalindrome(input, fIndex + 1, lIndex - 1);
		}
	}

	static int sumOfDidgits(int x) {
		if (x == 0) {
			return 0;
		} else {
			return ((x % 10) + sumOfDidgits(x / 10));
		}
	}

	public static void printRecCodes(String s, int length, Set<String> answer, char[] arr, int index) {

	
		if (index >= length) {
			return;
		}
		if (index == 0) {
			String newStr = new String();
			for (int i = 0; i < s.length(); i++) {
				int charIndex = s.charAt(i) - 48;
				newStr += arr[charIndex - 1];
			}
			answer.add(newStr);
			int pairIndex = 1;
			newStr = new String();
			newStr += arr[s.charAt(0) - 49];
			boolean ifTrue = true;
			for (; pairIndex < length;) {
				if (pairIndex + 1 < length) {
					int charIndex1 = s.charAt(pairIndex) - 48;
					int charIndex2 = s.charAt(pairIndex + 1) - 48;
					charIndex1 *= 10;
					charIndex1 += charIndex2;

					if (charIndex1 < 26) {
						newStr += arr[charIndex1 - 1];
					} else {
						ifTrue = false;
					}
					pairIndex += 2;
				} else {
					int charIndex1 = s.charAt(pairIndex) - 48;
					newStr += arr[charIndex1 - 1];
					pairIndex++;
				}
			}
			if (ifTrue)
				answer.add(newStr);
			else
				ifTrue = true;
			pairIndex = 0;
			newStr = new String();
			for (; pairIndex < length;) {
				if (pairIndex + 1 < length) {
					int charIndex1 = s.charAt(pairIndex) - 48;
					int charIndex2 = s.charAt(pairIndex + 1) - 48;
					charIndex1 *= 10;
					charIndex1 += charIndex2;

					if (charIndex1 < 26) {
						newStr += arr[charIndex1 - 1];

					} else {
						ifTrue = false;
					}
					pairIndex += 2;
				} else {
					int charIndex1 = s.charAt(pairIndex) - 48;
					newStr += arr[charIndex1 - 1];
					pairIndex++;
				}
			}
			if (ifTrue)
				answer.add(newStr);
			else
				ifTrue = true;
			printRecCodes(s, length, answer, arr, index + 1);
		} else {
			int pairIndex = 0;
			String newStr = new String();
			boolean ifTrue = true;
			for (; pairIndex < index;) {
				if (pairIndex + 1 < index) {
					int charIndex1 = s.charAt(pairIndex) - 48;
					int charIndex2 = s.charAt(pairIndex + 1) - 48;
					charIndex1 *= 10;
					charIndex1 += charIndex2;

					if (charIndex1 < 26) {
						newStr += arr[charIndex1 - 1];
					} else {
						ifTrue = false;
					}
					pairIndex += 2;
				} else {
					int charIndex1 = s.charAt(pairIndex) - 48;
					newStr += arr[charIndex1 - 1];
					pairIndex++;
				}
			}
			int temp = s.charAt(index) - 48;
			newStr += arr[temp - 1];
			pairIndex++;
			for (; pairIndex < length;) {
				if (pairIndex + 1 < length) {
					int charIndex1 = s.charAt(pairIndex) - 48;
					int charIndex2 = s.charAt(pairIndex + 1) - 48;
					charIndex1 *= 10;
					charIndex1 += charIndex2;

					if (charIndex1 < 26) {
						newStr += arr[charIndex1 - 1];
					} else {
						ifTrue = false;
					}
					pairIndex += 2;
				} else {
					int charIndex1 = s.charAt(pairIndex) - 48;
					newStr += arr[charIndex1 - 1];
					pairIndex++;
				}
			}
			if (ifTrue)
				answer.add(newStr);

			printRecCodes(s, length, answer, arr, index + 1);
		}

	}
	
	private static void printCodes(String str, String ans) {
	    if (str.length() == 0) {
	        System.out.println(ans);
	        return;
	    }

	    String ch1 = str.substring(0, 1);
	    String restOfTheString1 = str.substring(1);

	    if (Integer.parseInt(ch1, 10) > 0) {
	        char code = (char) (Integer.parseInt(ch1, 10) + 'a' - 1);
	        printCodes(restOfTheString1, ans + code);
	    }

	    if (str.length() >= 2) {
	        String ch12 = str.substring(0, 2);
	        String ros2 = str.substring(2);

	        if (Integer.parseInt(ch12, 10) > 0 && Integer.parseInt(ch12) <= 26) {
	            char code = (char) (Integer.parseInt(ch12, 10) + 'a' - 1);
	            printCodes(ros2, ans + code);
	        }
	        if (Integer.parseInt(ch12, 10) == 0) {
	            printCodes(ros2, ans);
	        }
	    }
	}
}
