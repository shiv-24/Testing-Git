package codingPractice.gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PhoneDirectory {
	//TODO Do it with Trie Once done the topic
	// https://www.geeksforgeeks.org/implement-a-phone-directory/

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase > 0) {
			int length = Integer.parseInt(br.readLine());

			String arr[] = new String[length];
			arr = br.readLine().split(" ");
			List<String> inputList = Arrays.asList(arr);
			Collections.sort(inputList);
			
			String query = br.readLine();

			for (int i = 0, j = 1; j <=query.length(); j++) {
				String subString = query.substring(i, j);
				printSearchResult(arr, subString, i);

			}

			testCase--;
		}
	}

	public static void printSearchResult(String[] arr, String query, int startIndex) {

		boolean printedSomething = false;
		List<String> result	=new ArrayList<String>();
		
		for (int i = 0; i < arr.length; i++) {

			String contactInfo = arr[i];

			if (contactInfo.startsWith(query, startIndex)) {
//				System.out.print(contactInfo + " ");
				if(!result.contains(contactInfo)) {
					result.add(contactInfo);
				}
				printedSomething = true;
			}
		}
		if (printedSomething) {
			for(int i=0;i<result.size();i++) {
				System.out.print(result.get(i)+" ");
			}
			System.out.println();
		} else {
			System.out.println(0);
		}
	}
}
