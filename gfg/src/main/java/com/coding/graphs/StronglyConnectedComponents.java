package com.coding.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class StronglyConnectedComponents {

	
	LinkedList<Integer> graph[];
	static boolean visited[];
	static Stack<Integer> nodeStack;
	
	public StronglyConnectedComponents(int nodes) {
		
		graph	=	new LinkedList[nodes];
		
		for(int i=0;i<nodes;i++)
			graph[i]	=	new LinkedList<>();
		
		visited	=	new boolean[nodes];
		
		nodeStack	=	new Stack<>();
	}
	
	public void dfsUtil(int start) {
		
		visited[start]=true;
		
		Iterator<Integer> ite	=	graph[start].iterator();
		
		while(ite.hasNext()) {
			
			int x	=	ite.next();
			if(!visited[x]) {
				dfsUtil(x);
			}
		}
	}
	
	public void dfs(int vertices) {
		
		for(int i=0;i<vertices;i++) {
			
			if(visited[i]) {
				dfsUtil(i);
			}
		}
		
	}
	
	public static void main(String[] args) {
	
		StronglyConnectedComponents obj	=	new StronglyConnectedComponents(5);
		StronglyConnectedComponents obj2	=	new StronglyConnectedComponents(5);
		if(obj==obj2) {
			System.out.println("1");
		}else{
			System.out.println("2");
		}
	}
	
	
	
	
}
