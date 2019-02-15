package com.coding.graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class BFS {

	List<CustomGraph> graph[];

	public BFS(int v) {
		graph = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			graph[i] = new LinkedList<>();
		}
	}

	public void bfsTraversal(int vertices, int start) {
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);
		visited.add(start);
		while (!queue.isEmpty()) {
			int front = queue.poll();
			System.out.print(front + " ");
			LinkedList<CustomGraph> fromList = (LinkedList<CustomGraph>) graph[front];
			for (int i = 0; i < fromList.size(); i++) {
				int to = fromList.get(i).to;
				if (!visited.contains(to)) {
					queue.add(to);
					visited.add(to);
				}

			}
		}
	}
	
	public boolean ifPath(int start, int dest) {

		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);
		visited.add(start);
		while (!queue.isEmpty()) {
			int front = queue.poll();
//			System.out.print(front + " ");
			LinkedList<CustomGraph> fromList = (LinkedList<CustomGraph>) graph[front];
			for (int i = 0; i < fromList.size(); i++) {
				int to = fromList.get(i).to;
				if (!visited.contains(to)) {
					queue.add(to);
					visited.add(to);
				}
				
				if(to==dest) {
					return true;
				}

			}
		}

		return false;
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int nodes = Integer.parseInt(br.readLine());
		int edges = Integer.parseInt(br.readLine());

		BFS obj = new BFS(nodes);
		
		Map<Integer,String> tempMap	=	new TreeMap<>();
		List<Pair> mappingList	=	new LinkedList<>();
		Set<String> distinctCities	=	new HashSet<>();
		
		for (int i = 0; i < edges; i++) {
			String[] inputValue = br.readLine().split(" ");
//			int from = Integer.parseInt(inputValue[0]);
//			int to = Integer.parseInt(inputValue[1]);
//
//			LinkedList<CustomGraph> fromList = (LinkedList<CustomGraph>) obj.graph[from];
//			CustomGraph cg = new CustomGraph(to, 1);
//			if (fromList != null) {
//				fromList.add(cg);
//
//			} else {
//				fromList = new LinkedList<>();
//				fromList.add(cg);
//
//			}
//
//			obj.graph[from] = fromList;
			mappingList.add(new Pair(inputValue[0],inputValue[1]));
			distinctCities.add(inputValue[0]);
			distinctCities.add(inputValue[1]);
		}
		
		
		int testCases	=	Integer.parseInt(br.readLine());
		
		List<String>answer	=	new ArrayList<>();
		
		for(int i=0;i<testCases;i++) {
			String srcAndDest[]	=	br.readLine().split(" ");
			int src	=	Integer.parseInt(srcAndDest[0]);
			int dest	=	Integer.parseInt(srcAndDest[1]);
			
			if(obj.ifPath(src, dest)) {
				answer.add("YES");
			}else {
				answer.add("NO");
			}
		}
		
		
		for(int i=0;i<answer.size();i++) {
			System.out.print(answer.get(i)+" ");
		}
//		obj.bfsTraversal(nodes, 2);
		
		
	}

}


class Pair{
	String name1, name2;
	
	public Pair(String name1, String name2) {
		this.name1	=	name1;
		this.name2	=	name2;
		// TODO Auto-generated constructor stub
	}
}
