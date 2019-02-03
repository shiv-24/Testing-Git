package com.pct.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Basic1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		
		String input	=	br.readLine();
		
		String[]name	=	input.split(" ");
		
		if(name.length==3) {
			System.out.println(name[2]+" "+name[0]+" "+name[1]);
		}else if(name.length==2) {
			if(name[1].charAt(name[1].length()-1)=='a'||
			   name[1].charAt(name[1].length()-1)=='e'||
			   name[1].charAt(name[1].length()-1)=='i'||
			   name[1].charAt(name[1].length()-1)=='o'||
			   name[1].charAt(name[1].length()-1)=='u') {
				System.out.println(name[1]+" "+name[0]);
			}else {
				System.out.println(name[0]+" "+name[1]);
			}
		}else {
			System.out.println(name[0]);
		}
	}
}
