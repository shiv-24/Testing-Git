package com.coding.graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ConstructionAndTraversal {

	int graph[][];
	LinkedList<CustomGraph> listGraph[];

	public ConstructionAndTraversal(int vertices) {
		graph = new int[vertices][vertices];
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				graph[i][j] = 0;
			}
		}

		listGraph = new LinkedList[vertices];

		for (int i = 0; i < listGraph.length; i++) {
			listGraph[i] = new LinkedList<>();
		}

	}

	public int[][] getGraph() {
		return graph;
	}

	public LinkedList<CustomGraph>[] getListGraph() {
		return listGraph;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int nodes = Integer.parseInt(br.readLine());
		int edges = Integer.parseInt(br.readLine());

		ConstructionAndTraversal obj = new ConstructionAndTraversal(nodes);

		for (int i = 0; i < edges; i++) {
			String[] inputValue = br.readLine().split(" ");
			int from = Integer.parseInt(inputValue[0]);
			int to = Integer.parseInt(inputValue[1]);
			int weight = Integer.parseInt(inputValue[2]);

			obj.graph[from][to] = weight;

			LinkedList<CustomGraph> fromList = new LinkedList<>();
			CustomGraph cg = new CustomGraph(to, weight);
			fromList.add(cg);
			obj.listGraph[from] = fromList;
		}

		for (int i = 0; i < nodes; i++) {
			for (int j = 0; j < nodes; j++) {
				if (obj.graph[i][j] != 0) {
					System.out.println(obj.graph[i][j]);
				}
			}
		}
		
		for(int i=0;i<nodes;i++) {
			LinkedList<CustomGraph> fromList	=	obj.listGraph[i];
			
			for(int j=0;j<fromList.size();j++) {
				System.out.println("Edge from"+i);
				System.out.println("Edge to"+fromList.get(j).to);
				System.out.println("Weight"+fromList.get(j).weight);
			}
		}
			
	}

}

class CustomGraph {

	int to;
	int weight;

	public CustomGraph(int val, int weight) {
		this.to = val;
		this.weight = weight;
	}
}