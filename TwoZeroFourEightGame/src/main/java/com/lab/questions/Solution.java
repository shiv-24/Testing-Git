package com.lab.questions;

public class Solution {

	class TreeNode {
		int val;
		TreeNode leftNode;
		TreeNode rightNode;

		public TreeNode(int x) {
			val = x;
			// TODO Auto-generated constructor stub
		}
	}

	int max = Integer.MIN_VALUE;
	int num = 0;

	public int longestUnivaluePath(TreeNode root) {

		if (root == null) {
			return num;
		}

		if (root.leftNode != null) {
			if (root.leftNode.val == root.val) {
				num++;
				if (max < num) {
					max = num;
				}
			} else {
				if (max < num) {
					max = num;
				}
				num = 0;
			}

			return longestUnivaluePath(root.leftNode);

		}

		if (root.rightNode != null) {
			if (root.leftNode.val == root.val) {
				num++;
				if (max < num) {
					max = num;
				}
			} else {
				if (max < num) {
					max = num;
				}
				num = 0;
			}
			return longestUnivaluePath(root.rightNode);

		}
		return max;
	}
	
//	public boolean backspaceCompare(String S, String T)
//	{
//		boolean ifEqual	=	false;
//		
//		for(int i=0;i<Math.max(S.length(),T.length());i++) {
//			
//			if(S.)
//		}
//		return ifEqual;
//		
//	}
}
