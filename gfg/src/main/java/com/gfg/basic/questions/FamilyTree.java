package com.gfg.basic.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FamilyTree {

	static Node root=null;
	
	class Node{
		String name;
		Node left;
		Node right;
		
		public Node(String name) {
			this.name	=	name;
			left 	=	null;
			right	=	null;
		}
		
	}
	
	
	public void createTree(Node tempNode, String parent, String child) {

		if (tempNode == null) {
			return;
		}
		if (tempNode.left == null && tempNode.right == null && tempNode.name.equalsIgnoreCase(parent)) {
			tempNode.left = new Node(child);

		} else {

			if (tempNode.name.equalsIgnoreCase(parent)) {
				if (tempNode.left != null) {
					tempNode.right = new Node(child);
				} else {
					tempNode.left = new Node(child);
				}

			} else {
				createTree(tempNode.left, parent, child);
				createTree(tempNode.right, parent, child);
			}

		}
	}
	
	 void printPreorder(Node node) 
	    { 
	        if (node == null) 
	            return; 
	  
	        /* first print data of node */
	        System.out.print(node.name + " "); 
	  
	        /* then recur on left sutree */
	        printPreorder(node.left); 
	  
	        /* now recur on right subtree */
	        printPreorder(node.right); 
	    } 
	
	public static void main(String[] args) throws Exception{
		int t;
		
		BufferedReader br	=	new BufferedReader(new InputStreamReader(System.in));
		
		t	=	Integer.parseInt(br.readLine());
		
		String arr[]	=	new String[t*2];
		
		for (int i = 0; i < t * 2; i += 2) {
			String input[]	=	br.readLine().split(" ");
			arr[i]=input[0];
			arr[i+1]=input[1];
		}
		
		FamilyTree obj	=	new FamilyTree();
		root	=	obj.new Node(arr[0].trim());
		
		for(int i=0;i<t*2;i+=2) {
			Node	tempNode	=	root;
			obj.createTree(tempNode, arr[i].trim(), arr[i+1].trim());
		}
		
		obj.printPreorder(root);
	}
}
