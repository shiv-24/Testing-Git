package com.coding.graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {

	LinkedList<Integer> adjacencyList[];
	static TopologicalSort obj;
	
	public TopologicalSort(int nodes) {
		adjacencyList = new LinkedList[nodes];
		for (int i = 0; i < nodes; i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}
	
	public void dfs(int node, Stack<Integer> stack, boolean visited[]) {
		
		visited[node]=true;
		
		LinkedList<Integer> toNodes	= obj.adjacencyList[node];
		
		for(int i=0;i<toNodes.size();i++) {
			if(!visited[toNodes.get(i)]) {
				dfs(toNodes.get(i),stack,visited);
			}
		}
		
		stack.push(node);
		
	}
	
	public void dfsUtil(int nodes) {
		
		boolean visited[]	= new boolean[nodes];
		
		for(int i=0;i<nodes;i++) {
			visited[i]=false;
		}
		
		Stack<Integer> stack	=	new Stack<>();
		
		for(int i=0;i<nodes;i++) {
			if(!visited[i]) {
				dfs(i,stack,visited);
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nodes = Integer.parseInt(br.readLine());
		int edges = Integer.parseInt(br.readLine());
		
		obj	=	new TopologicalSort(nodes);
		
		for (int i = 0; i < edges; i++) {
			String input[]	=	br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			obj.adjacencyList[from].add(to);
		}
		
		obj.dfsUtil(nodes);
	}
}

class TopologicalGraph{
	int to;
	int reachTime;
	int finalTime;
	
	public TopologicalGraph(int to) {
		this.to	=	to;
		reachTime=0;
		finalTime=0;
	}
	
}