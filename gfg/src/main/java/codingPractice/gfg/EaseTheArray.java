package codingPractice.gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EaseTheArray {

	public static void main(String[] args) throws Exception {
//		Scanner in	=	new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
//		int testCase	=	in.nextInt();
		int testCase	=	Integer.parseInt(br.readLine());
		while(testCase>0) {
//			int n	=	in.nextInt();
			int n	=	Integer.parseInt(br.readLine());
			String []str	=	br.readLine().split(" ");
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
//				int x	=	in.nextInt();
				int x	=	Integer.parseInt(str[i]);
				arr[i]=x;
			}
			changeArray(arr, n);
			arr=indexChange(arr, n);
			for(int i=0;i<n;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			testCase--;
		}
	}	 
	
	public static void changeArray(int[] arr, int n) {

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != 0 && arr[i] == arr[i + 1]) {
				arr[i] = arr[i] * 2;
				arr[i + 1] = 0;
			}
		}

	}
	
	public static int[] indexChange(int[] arr,int n) {
		int [] newArray	=	new int[n];
		int j=0;
		for(int i=0;i<n;i++) {
			if(arr[i]!=0) {
				newArray[j]=arr[i];
				j++;
			}
		}
		if(j<n) {
			for(int i=j;i<n;i++) {
				newArray[i]=0;
			}
		}
		return newArray;
	}
}
