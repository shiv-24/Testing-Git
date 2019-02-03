package com.pct.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//One mistake is that I need to enter again for the new line to end. SO need to correct that.
public class Basic2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> distinctWords = new HashSet<>();

		String input = new String();
		
		while ((input = br.readLine()).length()!=0) {
			StringBuffer tempBuffer = new StringBuffer();
			for (int i = 0; i < input.length(); i++) {
				int charVal = (int) input.charAt(i);
				if (charVal != 9 && charVal != 32) {
					tempBuffer.append(input.charAt(i));
				} else {
					String tempString = new String(tempBuffer);
					distinctWords.add(tempString.toLowerCase());
					tempBuffer = new StringBuffer();
				}

			}
			if(tempBuffer!=null) {
				distinctWords.add(tempBuffer.toString().toLowerCase());
			}
		}
		System.out.println(distinctWords.size());
	}

}
