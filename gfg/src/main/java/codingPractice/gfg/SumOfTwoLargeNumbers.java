package codingPractice.gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SumOfTwoLargeNumbers {

	public static void main(String[] args) throws Exception{
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		
		int testCase	=	Integer.parseInt(br.readLine());
		
		while(testCase>0) {
			
			String xyArr[]	=	br.readLine().split(" ");
			String x	=	xyArr[0];
			String y	=	xyArr[1];
			sum(x, y);
			testCase--;
		}
	}
	
	public static void sum(String x, String y) {
		List sumList	=	new ArrayList<Integer>();
		
		if(x.length()>=y.length()) {
			int j	=	y.length()-1;
			int carry	=	0;
			int xChar=-1, yChar=-1;
			for(int i=x.length()-1;i>=0;i--,j--) {
				xChar	=	x.charAt(i)-48;
				if(j>=0) {
				yChar	=	y.charAt(j)-48;
				}else {
					yChar=0;
				}
				int sum	=	(xChar+yChar+carry)%10;
				carry	=	(xChar+yChar+carry)/10;
				sumList.add(sum);
			}
			if(carry!=0) {
				sumList.add(carry);
			}
		}else {
			int j	=	x.length()-1;
			int carry	=	0;
			int xChar=-1, yChar=-1;
			for(int i=y.length()-1;i>=0;i--,j--) {
				yChar	=	y.charAt(i)-48;
				if(j>=0) {
				xChar	=	x.charAt(j)-48;
				}else {
					xChar=0;
				}
				int sum	=	xChar+yChar+carry;
				carry	=	sum%10;
				sumList.add(sum);
			}
			if(carry!=0) {
				sumList.add(carry);
			}
		}
		
		if(x.length()==sumList.size()) {
			for(int i=sumList.size()-1;i>=0;i--) {
				System.out.print(sumList.get(i));
			}
			System.out.println();
		}else {
			System.out.println(x);
		}
	} 
}
