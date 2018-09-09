package codingPractice.gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RemoveCommonCharactersAndConcatenate {

	// https://www.geeksforgeeks.org/concatenated-string-uncommon-characters-two-strings/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		while (testCase > 0) {
			String firstString = br.readLine();
			String secondString = br.readLine();

			printAnswer(firstString, secondString);
			testCase--;
//			int firstStringIndexArr[] = new int[26];
//			int secondStringIndexArr[] = new int[26];
//			StringToIndex(firstString, firstStringIndexArr);
//			StringToIndex(secondString, secondStringIndexArr);
//			printUnCommonString(firstStringIndexArr, secondStringIndexArr);
			// for(int i=0;i<26;i++) {
			// System.out.println(firstStringIndexArr[i]);
			// }
		}
	}
	
	public static void printAnswer(String first, String second) {
		
		boolean printedSomething	=	false;
		for(int i=0;i<first.length();i++) {
			if(second.indexOf(first.charAt(i))==-1) {
				System.out.print(first.charAt(i));
				printedSomething	=	true;
			}
		}
		for(int i=0;i<second.length();i++) {
			if(first.indexOf(second.charAt(i))==-1) {
				System.out.print(second.charAt(i));
				printedSomething	=	true;
			}
		}
		if(printedSomething==false) {
			System.out.print(-1);
		}
		System.out.println();
	}
	
	

	public static void StringToIndex(String s, int[] arr) {

		for (int i = 0; i < s.length(); i++) {
			arr[(s.charAt(i) - 97)]++;

		}
	}

	public static void printUnCommonString(int[] indexOfFirst, int[] indexOfSecond) {

		char[] first = new char[200];
		char[] second = new char[200];
		int lenFirst = 0;
		int lenSecond = 0;
		for (int i = 0; i < 26; i++) {
			if (indexOfFirst[i] != 0 && indexOfSecond[i] != 0) {
				continue;
			} else if (indexOfFirst[i] != 0 && indexOfSecond[i] == 0) {
				int count = indexOfFirst[i];

				while (count > 0) {

					char c = (char) (i + 97);
					first[lenFirst] = c;
					lenFirst++;
					count--;
				}

			} else if (indexOfFirst[i] == 0 && indexOfSecond[i] != 0) {
				int count = indexOfSecond[i];

				while (count > 0) {

					char c = (char) (i + 97);
					second[lenSecond] = c;
					lenSecond++;
					count--;
				}
			}
		}

		String finalString = new String(first);
		finalString.concat(new String(second));

		System.out.println(finalString);
	}
}
