package com.coding.trees;

public class InorderPreorderToPostorder {

	public static int preIndex = 0;
	
	public void postOrderTrav(int in[], int pre[], int start, int end) {

		if (start > end) {
			return;
		}

		int index = search(in, start, end, pre[preIndex++]);
		
		postOrderTrav(in, pre, start, index-1);
		
		postOrderTrav(in, pre, index+1, end);
		
		System.out.println(in[index]+" ");
	}

	public static int search(int[] in, int start, int end, int data) {
		int i = 0;
		for (i = start; i < end; i++) {
			if (in[i] == data) {
				return i;
			}
		}
		return i;
	}

	public void preOrderTrav(int in[], int post[], int start, int end, int postIndex) {

		if (start > end) {
			return;
		}
		
		int index = search(in, start, end, post[postIndex]);
		
		System.out.println(in[index]+" ");
		
		preOrderTrav(in, post, start, index-1,postIndex-1);
		
		preOrderTrav(in, post, index+1, end,postIndex-1);
		
		
	}	
	
	public static void main(String[] args) {
		
			int in[] = { 4, 2, 5, 1, 3, 6 }; 
//	        int pre[] = { 1, 2, 4, 5, 3, 6 };
			int post[] = { 4, 5, 2, 6, 3, 1 }; 
	        int len = in.length; 
	        InorderPreorderToPostorder tree = new InorderPreorderToPostorder(); 
//	        tree.postOrderTrav(in, pre, 0, len - 1);
	        tree.preOrderTrav(in, post, 0, len-1, len-1);
	}

}
