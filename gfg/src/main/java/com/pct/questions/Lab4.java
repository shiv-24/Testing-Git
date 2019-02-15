package com.pct.questions;

public class Lab4 {

	Tree root;

	public Lab4() {
		// TODO Auto-generated constructor stub
		root = null;
	}

	public Tree constructBST(Tree root, int x) {
		if (root == null) {
			root = new Tree(x);
			return root;

		}

		if (root.data > x) {
			root.left = constructBST(root.left, x);
		} else {
			root.right = constructBST(root.right, x);
		}

		return root;

	}

	public void insert(int x) {
		root=constructBST(root, x);
	}

	public boolean ifAvl(Tree root) {

		int lh, rh;

		if (root == null) {
			return true;
		}

		lh = height(root.left);
		rh = height(root.right);

		if (Math.abs(lh - rh) < 1 && ifAvl(root.left) && ifAvl(root.right)) {

			return true;
		}

		return false;
	}

	public int height(Tree root) {

		if (root == null) {
			return 0;
		}

		return 1 + Math.max(height(root.left), height(root.right));

	}

	public void preOrder(Tree root) {

		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void main(String[] args) {

		Lab4 obj = new Lab4();

		obj.insert(7);
		obj.insert(5);
		obj.insert(8);
		obj.insert(3);
		obj.insert(12);
		obj.insert(23);
		obj.insert(9);
		obj.insert(27);
		obj.insert(55);
		obj.insert(33);
		obj.insert(2);
		

		if (obj.ifAvl(obj.root)) {
			obj.preOrder(obj.root);
		}else {
			System.out.println("NOT");
		}
	}

}

class Tree {

	int data;
	Tree left, right;

	public Tree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
