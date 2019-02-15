package com.coding.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeViews {

	// Node root;

	public static void topView(ViewSpecificNode root) {
		if (root == null) {
			return;
		}

		Queue<ViewSpecificNode> queue = new LinkedList<>();

		queue.add(root);
		root.hd = 0;
		Map<Integer, ViewSpecificNode> topViewNodes = new TreeMap<>();

		while (!queue.isEmpty()) {

			ViewSpecificNode temp = queue.poll();

			if (topViewNodes.get(temp.hd) == null) {

				topViewNodes.put(temp.hd, temp);

			}

			if (temp.left != null) {
				temp.left.hd = temp.hd - 1;
				queue.add(temp.left);
			}

			if (temp.right != null) {
				temp.right.hd = temp.hd + 1;
				queue.add(temp.right);
			}
		}

		Iterator<Integer> ite = topViewNodes.keySet().iterator();

		while (ite.hasNext()) {
			int t = ite.next();
			System.out.print(topViewNodes.get(t).data+" ");
		}
	}
	
	public static void bottomView(ViewSpecificNode root) {
		if (root == null) {
			return;
		}

		Queue<ViewSpecificNode> queue = new LinkedList<>();

		queue.add(root);
		root.hd = 0;
		Map<Integer, ViewSpecificNode> topViewNodes = new TreeMap<>();

		while (!queue.isEmpty()) {

			ViewSpecificNode temp = queue.poll();

			topViewNodes.put(temp.hd, temp);

			

			if (temp.left != null) {
				temp.left.hd = temp.hd - 1;
				queue.add(temp.left);
			}

			if (temp.right != null) {
				temp.right.hd = temp.hd + 1;
				queue.add(temp.right);
			}
		}

		Iterator<Integer> ite = topViewNodes.keySet().iterator();
		System.out.println();
		while (ite.hasNext()) {
			int t = ite.next();
			System.out.print(topViewNodes.get(t).data+" ");
		}
	}
	
	public static ViewSpecificNode insert(ViewSpecificNode root, int data) {
		if (root == null) {
			return new ViewSpecificNode(data);
		} else {
			ViewSpecificNode cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int t = scan.nextInt();
		ViewSpecificNode root = null;
		
//		while (t-- > 0) {
//			int data = scan.nextInt();
//			root = insert(root, data);
//		}
		root = new ViewSpecificNode(1); 
        root.left = new ViewSpecificNode(2); 
        root.right = new ViewSpecificNode(3); 
        root.left.right = new ViewSpecificNode(4); 
        root.left.right.right = new ViewSpecificNode(5); 
        root.left.right.right.right = new ViewSpecificNode(6); 
		topView(root);
		bottomView(root);
//		scan.close();

	}
}

class ViewSpecificNode {
	int data, hd;
	ViewSpecificNode left, right;

	public ViewSpecificNode(int data) {
		this.data = data;
		hd = 0;
		left = null;
		right = null;
	}
}