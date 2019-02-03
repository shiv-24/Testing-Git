package com.coding.trees;

public class ReplaceEachNode {

	Node root;
	
	public ReplaceEachNode() {
		root	=	null;
	}
	
	public int inorderSum(Node root) {
		
		if(root==null) {
			return 0;
		}
		if(root.right==null && root.left==null) {
			return root.data;
		}else {
			int lh	=	0;
			int rh	=	0;
			
			lh+=inorderSum(root.left);
			rh+=inorderSum(root.right);
			
			return root.data+lh+rh;
		}
	}
	
	
	public static void main(String[] args) {
		ReplaceEachNode obj	=	new  ReplaceEachNode();
		obj.root	=	new Node(1);
		obj.root.left	=	new Node(2);
		obj.root.left.left	=	new Node(4);
		obj.root.left.right	=	new Node(5);
		
		obj.root.right	=	new Node(3);
		obj.root.right.left	=	new Node(6);
		obj.root.right.right	=	new Node(7);
		
		System.out.println(obj.inorderSum(obj.root.left));
	}
}


//class Node{
//	
//	int data;
//	Node left, right;
//	
//	public Node(int x) {
//		this.data	=	x;
//		left=right=null;
//	}
//}