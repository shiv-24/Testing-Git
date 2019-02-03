package com.coding.graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DFS {

	List<CustomGraph> graph[];

	public DFS(int v) {
		graph = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			graph[i] = new LinkedList<>();
		}
	}

//	public void bfsTraversal(int vertices, int start) {
//		Set<Integer> visited = new HashSet<>();
//		Queue<Integer> queue = new LinkedList<>();
//
//		queue.add(start);
//		visited.add(start);
//		while (!queue.isEmpty()) {
//			int front = queue.poll();
//			System.out.print(front + " ");
//			LinkedList<CustomGraph> fromList = (LinkedList<CustomGraph>) graph[front];
//			for (int i = 0; i < fromList.size(); i++) {
//				int to = fromList.get(i).to;
//				if (!visited.contains(to)) {
//					queue.add(to);
//					visited.add(to);
//				}
//
//			}
//		}
//	}
	
	static Set<Integer> visited	=	new HashSet<>();
	
	public void dfs(int start) {
	
		if(visited.contains(start)) {
			return;
		}else {
			visited.add(start);
		}
		System.out.print(start+" ");
		
		LinkedList<CustomGraph> fromList	=	(LinkedList<CustomGraph>) graph[start];
		
		for(int i=0;i<fromList.size();i++) {
			if(!visited.contains(fromList.get(i).to))
			dfs(fromList.get(i).to);
		}
	}
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int nodes = Integer.parseInt(br.readLine());
		int edges = Integer.parseInt(br.readLine());

		DFS obj = new DFS(nodes);

		for (int i = 0; i < edges; i++) {
			String[] inputValue = br.readLine().split(" ");
			int from = Integer.parseInt(inputValue[0]);
			int to = Integer.parseInt(inputValue[1]);
			int weight = Integer.parseInt(inputValue[2]);

			// obj.graph[from][to] = weight;

			LinkedList<CustomGraph> fromList = (LinkedList<CustomGraph>) obj.graph[from];
			CustomGraph cg = new CustomGraph(to, weight);
			if (fromList != null) {
				fromList.add(cg);

			} else {
				fromList = new LinkedList<>();
				fromList.add(cg);

			}

			obj.graph[from] = fromList;

		}

		obj.dfs(2);
	}

	
}
