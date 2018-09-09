package gfg.LinkedList;

public class MainLinkedListClass {

	Node head;
	
	class Node{
		
		int data;
		Node next;
		
		Node(int x){
			data=x;
			next=null;
		}
	}
	
	
	public void push(int x) {
		Node tempNode;
		
		if(head==null) {
			head	=	new Node(x);
			return;
		}
		
		tempNode	=	new Node(x);
		tempNode.next	=	head;
		head	=	tempNode;
		
	}
	
	public void traverseList() {
		
		Node tempNode	=	head;
		while(tempNode!=null) {
			System.out.println(tempNode.data);
			tempNode	=	tempNode.next;	
		}
	}
	
	public void deleteList() {
		head	=	null;
	}
	
	public int lengthIterative() {
		
		int length	=	0;
		Node tempNode	=	head;
		if(head==null) {
			return length;
		}
		
		while(tempNode!=null) {
			length++;
			tempNode	=	tempNode.next;
		}
		return length;
	}
	
	public int lengthRecursive(Node tempNode) {

		if (tempNode == null) {
			return 0;
		}

		return 1 + lengthRecursive(tempNode.next);

	}
	
	public int lengthRechelper() {
		return lengthRecursive(head);
	}
	
	public boolean searchTransitive(int x){
		boolean result	=	false;
		Node tempNode	=	head;
		if(head==null) {
			return result;
		}
		
		while(tempNode!=null) {
			if(tempNode.data==x) {
				result =true;
				break;
			}
			tempNode.next	=	tempNode;
		}
		
		return result;
	} 
	
	public boolean searchRecursive(Node tempNode, int x) {

		if (tempNode == null) {
			return false;
		}
		
		if (tempNode.data == x) {
			return true;
		} else {
			return searchRecursive(tempNode.next, x);
		}
	}	
	
	public int getNth(Node tempNode, int ind) {

		if (tempNode == null || ind < 0) {
			return -1;
		} else if (ind == 0) {
			return tempNode.data;
		} else {
			return getNth(tempNode.next, ind-1);
		}

	}
	
	public static void main(String args[]) {
		
		MainLinkedListClass obj	=	new MainLinkedListClass();
		obj.push(6);
		obj.push(5);
		obj.push(4);
		obj.push(3);
		obj.push(2);
		obj.push(1);
//		obj.traverseList();
//		System.out.println(obj.lengthRechelper());
//		System.out.println(obj.searchRecursive(obj.head, 10));
		System.out.println(obj.getNth(obj.head, 2));
	}
}
