package com.coding.trees;

public class SumTree {

	Node root;

	public SumTree() {
		root = null;
	}

	public boolean ifSumTree(Node root) {

		if (root == null) {
			return true;
		}
		if(root.right==null && root.left==null) {
			return true;
		}

		if (root.data == (childNodeSum(root.left) + childNodeSum(root.right)) && ifSumTree(root.left)
				&& ifSumTree(root.right)) {
			return true;
		} else {
			return false;
		}

	}

	public int childNodeSum(Node root) {

		if (root == null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return root.data;
		}

		int lh = childNodeSum(root.left);
		int rh = childNodeSum(root.right);

		return lh + rh + root.data;

	}

	public static void main(String[] args) {

		SumTree obj = new SumTree();
		obj.root = new Node(26);
		obj.root.left = new Node(12);
		obj.root.left.right = new Node(6);
		obj.root.left.left = new Node(6);
		obj.root.right = new Node(1);
		obj.root.right.right = new Node(-1);

		System.out.println(obj.ifSumTree(obj.root));

	}

}

//class Node {
//
//	int data;
//	Node right, left;
//
//	public Node(int i) {
//		this.data = i;
//		right = left = null;
//	}
//
//}