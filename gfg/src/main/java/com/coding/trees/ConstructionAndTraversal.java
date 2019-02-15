package com.coding.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ConstructionAndTraversal {

	Node root;

	public ConstructionAndTraversal() {
		root = null;
	}
	
	public Node construct(Node root, int data) {
		if(root==null) {
			root=new Node(data);
			return root;
		}
		
		Queue<Node> queue	= new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node temp	=	queue.poll();
			
			if(temp.left==null) {
				temp.left=new Node(data);
				break;
			}else {
				queue.add(temp.left);
			}
			
			if(temp.right==null) {
				temp.right=new Node(data);
				break;
			}else {
				queue.add(temp.right);
			}
		}
		
		return root;
	}

	public void insertAtFirstPos(Node root, int x) {
		List<Node> nodesPerLevel = new ArrayList<>();

		if (root == null) {
			root = new Node(x);
			return;
		} else {
			if (root.left == null) {
				root.left = new Node(x);
				return ;
			} else if (root.right == null) {
				root.right = new Node(x);
				return ;
			} else {
				nodesPerLevel.add(root.right);
				nodesPerLevel.add(root.left);
				int index = 0;
				while (true) {

					Node temp = nodesPerLevel.get(index);

					if (temp.left == null) {
						temp.left = new Node(x);
						return;
					} else if (temp.right == null) {
						temp.right = new Node(x);
						return;	
					} else {
						nodesPerLevel.add(temp.left);
						nodesPerLevel.add(temp.right);
					}
					index += 1;

				}
			}

		}

	}
	
	public void printPreorder(Node root) {
		
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
	
	public void normalDelete(Node root,int x) {
		
		if(root==null) {
			return;
		}else {
			if(root.data==x) {
				
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		ConstructionAndTraversal obj	=	new ConstructionAndTraversal();
//		
//		obj.root	=	new Node(10);
//		obj.root.left	=	new Node(11);
//		obj.root.left.left	=	new Node(7);
//		obj.root.right	=	new Node(9);
//		obj.root.right.left	=	new Node(15);
//		obj.root.right.right	=	new  Node(8);
		Scanner sc	=	new Scanner(System.in);
		int count=0;
		while(sc.hasNext()) {
			obj.root	=	obj.construct(obj.root, sc.nextInt());
			count++;
			if(count==6)
				break;
		}
		sc.close();
//		Node temp	=	new 
//		obj.insertAtFirstPos(obj.root, 12);
		obj.printPreorder(obj.root);
				
	}
}

class Node {

	int data;
	Node left, right;

	public Node(int x) {
		this.data = x;
		left = null;
		right = null;
	}
	
//	public Node(Node x) {
//		
//	}

}
