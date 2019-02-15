package com.coding.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SizeAndHeight {

	Node root;
	
	public SizeAndHeight() {
		root	=	null;
	}
	
	public int getSize(Node root) {
		if(root==null) {
			return 0;
		}
		
		return 1+ getSize(root.left)+getSize(root.right);
	}
	
	public int getHeight(Node root) {
		
		if(root==null) {
			return 0;
		}
//		if(root.left==null && root.right==null) {
//			return 1;
//		}
		
		return 1+ Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public double getDensity(Node root) {
		
		if(root==null) {
			return 0;
		}
		
		Queue<Node> totalNodes	=	new LinkedList<>();
		
		totalNodes.add(root);
		totalNodes.add(null);
		
		int level	=	0;
		int size	=	0;
		while(totalNodes.size()!=0) {
			
			while(totalNodes.peek()!=null) {
				Node tempNode	=	totalNodes.peek();
				totalNodes.remove();
				size++;
				
				if(tempNode.left!=null) {
					totalNodes.add(tempNode.left);
				}
				if(tempNode.right!=null) {
					totalNodes.add(tempNode.right);
				}
			}
			
			totalNodes.remove();
			level+=1;
			if(totalNodes.size()==0) {
				break;
			}
			totalNodes.add(null);
			
			
		}
		
		return  size*1.0/level;
	}
	
	
	public static void main(String[] args) {
		SizeAndHeight obj	=	new  SizeAndHeight();
		
		obj.root	=	new Node(11);
		obj.root.left	=	new Node(8);
		obj.root.right	=	new Node(3);
		obj.root.left.left	=	new Node(3);
		obj.root.left.right	=	new Node(5);
		obj.root.right.left	=	new Node(2);
//		obj.root.right.right	=	new Node(1);
		
		System.out.println(obj.getSize(obj.root));
		System.out.println(obj.getHeight(obj.root));
		System.out.println(obj.getDensity(obj.root));
	}
}
