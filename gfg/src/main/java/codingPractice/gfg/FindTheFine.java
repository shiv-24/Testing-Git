package codingPractice.gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindTheFine {

	public static void main(String[] args) throws Exception {
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		
		int testCase	=	Integer.parseInt(br.readLine());
		
		while(testCase>0) {
			String []totalPlusDateArr	=	br.readLine().split(" ");
			int n	=	Integer.parseInt(totalPlusDateArr[0]);
			int date	=	Integer.parseInt(totalPlusDateArr[1]);
			
			String carNumStrArr[]	=	br.readLine().split(" ");
			String penaltyStrArr[]	=	br.readLine().split(" ");
			Double totalPenalty	=	0.0;
			for(int i=0;i<n;i++) {
				int carNum	=	Integer.parseInt(carNumStrArr[i]);
				if(date%2==0 && carNum%2!=0) {
					int carPenalty	=	Integer.parseInt(penaltyStrArr[i]);
					totalPenalty+=carPenalty;
				}else if(date%2!=0 && carNum%2==0) {
					int carPenalty	=	Integer.parseInt(penaltyStrArr[i]);
					totalPenalty+=carPenalty;
				}
			}
			System.out.println(totalPenalty.intValue());
			testCase--;
		}
	}
}
