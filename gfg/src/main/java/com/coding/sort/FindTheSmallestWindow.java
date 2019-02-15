package com.coding.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindTheSmallestWindow {

//	public static String findSmallestSub(String str, String letter) {
//		Map<Character, Integer> charFrequency = new LinkedHashMap<>();
//		fillValues(charFrequency, letter);
//
//		int start = -1, end = -1, minSize = Integer.MAX_VALUE;
//		String answer=null;
//		for (int i = 0; i < str.length();) {
//
//			char strChar = str.charAt(i);
//
//			if (charFrequency.containsKey(strChar)) {
//				start = i;
//				charFrequency.put(strChar, charFrequency.get(strChar) - 1);
//				for (int j = start + 1; j < str.length(); j++) {
//					char nextChar = str.charAt(j);
//
//					if (charFrequency.containsKey(nextChar)) {
//						if(charFrequency.get(nextChar)!=0)
//						charFrequency.put(nextChar, charFrequency.get(nextChar) - 1);
//						if (allCharIncluded(charFrequency)) {
//							end = j;
//							fillValues(charFrequency, letter);
//							break;
//						}
//					}
//				}
//				if (minSize > (end - start)) {
//					minSize = (end - start);
//					answer	= str.substring(start, end+1);	
//				}
//				i=end+1;
//			
//			} else {
//				i += 1;
//			}
//
//		}
////		findSmallestSub(str.substring(start, end+1), letter);
//		return answer;
//	}
//
//	public static boolean allCharIncluded(Map<Character, Integer> charFrequency) {
//
//		Iterator<Character> ite = charFrequency.keySet().iterator();
//
//		while (ite.hasNext()) {
//			char key = ite.next();
//			if (charFrequency.get(key) != 0) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public static void fillValues(Map<Character, Integer> charFrequency, String letter) {
//		int letLen = letter.length();
//		for (int i = 0; i < letLen; i++) {
//			if (charFrequency.get(letter.charAt(i)) != null) {
//				charFrequency.put(letter.charAt(i), charFrequency.get(letter.charAt(i)) + 1);
//			} else {
//				charFrequency.put(letter.charAt(i), 1);
//			}
//		}
//	}

	public static String findSmallestSub(String str, String letter) {
		 int hashLen	=	str.length();
		 int patLen		=	letter.length();
		 
		 if(patLen>hashLen) {
			 return " ";
		 }
		
		 int totalChar	=	256;
		 
		 int has_str[]	=	new int[totalChar];
		 
		 int pat_str[]	=	new int[totalChar];
		 
		 for(int i=0;i<patLen;i++) {
			 pat_str[letter.charAt(i)]++;
		}
		 int start=0, start_in=0, minLen	=	Integer.MAX_VALUE, count=0;
		 
		 for(int i=0;i<hashLen;i++) {
			 has_str[str.charAt(i)]++;
			 
			 if(pat_str[str.charAt(i)]!=0 && has_str[str.charAt(i)]<=pat_str[str.charAt(i)])
				 count++;
			 
			 if(count==patLen) {
				 
				 while( has_str[str.charAt(start)]>pat_str[str.charAt(start)] || pat_str[str.charAt(start)]==0) {
					 
					 if(has_str[str.charAt(start)]>pat_str[str.charAt(start)])
						 has_str[str.charAt(start)]--;
					 start++;
				 }
				 
				 if(minLen>(i-start+1)) {
					 minLen=(i-start+1);
					 start_in=start;
				 }
			 }
		 }
		 
		 if(start_in==-1) {
			 return "";
		 }else {
			 return str.substring(start_in, start_in+minLen);
		 }
	} 
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		
		String str	=	br.readLine();
		String letter	=	br.readLine();
		String answer	=	findSmallestSub(str, letter);
//		answer	=	findSmallestSub(answer, letter);
		System.out.println(answer);
		
	}
}
