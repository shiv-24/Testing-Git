package com.codingpractice.hackerblocks;

//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.regex.*;
//
//public class Solution {
//
//	// Complete the sockMerchant function below.
//	static int sockMerchant(int n, int[] ar) {
//		Map<Integer, Integer> pairedSocks = new HashMap<Integer, Integer>();
//		int answer = 0;
//		for (int i = 0; i < ar.length; i++) {
//			if (pairedSocks.get(ar[i]) == null) {
//				pairedSocks.put(ar[i], 1);
//			} else {
//				pairedSocks.put(ar[i], pairedSocks.get(ar[i]) + 1);
//			}
//		}
//		Iterator<Integer> ite = pairedSocks.keySet().iterator();
//		while (ite.hasNext()) {
//			int key = ite.next();
//
//			answer += pairedSocks.get(key) / 2;
//
//		}
//		return answer;
//
//	}
//
//	private static final Scanner scanner = new Scanner(System.in);
//
//	public static void main(String[] args) throws IOException {
//		// BufferedWriter bufferedWriter = new BufferedWriter(new
//		// FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int n = scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		int[] ar = new int[n];
//
//		String[] arItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int i = 0; i < n; i++) {
//			int arItem = Integer.parseInt(arItems[i]);
//			ar[i] = arItem;
//		}
//
//		int result = sockMerchant(n, ar);
//
//		System.out.println(result);
//		// bufferedWriter.write(String.valueOf(result));
//		// bufferedWriter.newLine();
//		//
//		// bufferedWriter.close();
//
//		scanner.close();
//		
//		Queue<Integer> qu	=	new LinkedList<Integer>();
////		qu.
//	}
//}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
    	List<Integer> costList	=	new ArrayList<>();
    	
    	for(int i=0;i<cost.length;i++) {
    		costList.add(cost[i]);
    	}
  
    	for(int i=0;i<costList.size();i++)
    	{
    		int temp	=	costList.get(i);
    		int rem	=	Math.abs(temp-money);
//    		costList.
    		int index	=	costList.lastIndexOf(rem);
    		
    		if(index!=-1 && index!=i) {
    			index+=1;
    			i+=1;

    			
    			if(index<i) {
    				System.out.println(index+" "+i);
    			}else {
    				System.out.println(i+" "+index);
    			}
    			break;
    		}
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
