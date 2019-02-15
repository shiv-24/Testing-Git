package com.coding.trees;

public class ChildrenSumProperty {
	
	Node root;
	
	public ChildrenSumProperty(){
		root=null;
	}
	
	public boolean ifChildSum(Node root) {
	
		if(root==null) {
			return true;
		}
		
		if(root.left==null && root.right==null) {
			return true;
		}
		
		int leftData	=	0;
		int rightData	=	0;
		
		if(root.left!=null) {
			leftData	=	root.left.data;
		}
		
		if(root.right!=null) {
			rightData	=	root.right.data;
		}
		
		if(root.data==(leftData+rightData) && ifChildSum(root.left) && ifChildSum(root.right)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
	
		ChildrenSumProperty obj	=	new  ChildrenSumProperty();
		
		obj.root	=	new Node(11);
		obj.root.left	=	new Node(8);
		obj.root.right	=	new Node(3);
		obj.root.left.left	=	new Node(3);
		obj.root.left.right	=	new Node(5);
		obj.root.right.left	=	new Node(2);
		obj.root.right.right	=	new Node(1);
		
		System.out.println(obj.ifChildSum(obj.root));
		
	}
}
