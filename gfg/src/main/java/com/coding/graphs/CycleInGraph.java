package com.coding.graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CycleInGraph {

	List<Node> graph;
	Map<Integer, Node> nodeMap;

	public CycleInGraph(int v) {
		graph = new LinkedList<>();
		nodeMap = new HashMap<>();
	}

	static Set<Integer> visited = new HashSet<>();


	public boolean dfs() {

		boolean answer = false;
		Queue<Node> queue	=	new LinkedList<>();
		
		for (int i = 0; i < graph.size(); i++) {
			
			Node start	=	graph.get(i);
			Set<Node> visited	=	new HashSet<>();
			visited.add(start);
			queue.add(start);
			
			while(queue.size()!=0) {
			
				Node	temp	=	queue.poll();
				
				for(int j=0;j<temp.toList.size();j++) {
					if(visited.contains(temp.toList.get(j))) {
						answer	=	true;
						break;
					}else {
						queue.add(temp.toList.get(j));
						visited.add(temp.toList.get(j));
					}
				}
			}
			
			if(answer) 
				break;
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int nodes = Integer.parseInt(br.readLine());

		CycleInGraph obj = new CycleInGraph(nodes);

		for (int i = 0; i < nodes; i++) {
			String[] inputValue = br.readLine().split(" ");
			int process = Integer.parseInt(inputValue[0]);
			int hold = Integer.parseInt(inputValue[1]);
			int required = Integer.parseInt(inputValue[2]);

			Node processNode = null, holdNode = null, requireNode = null;

			if (obj.nodeMap.get(process) == null && process != -1) {
				processNode = new Node(process);
				obj.nodeMap.put(process, processNode);
			} else if (process != -1) {
				processNode = obj.nodeMap.get(process);
			}

			if (obj.nodeMap.get(hold) == null && hold != -1) {
				holdNode = new Node(hold);
				obj.nodeMap.put(hold, holdNode);
			} else if (hold != -1) {
				holdNode = obj.nodeMap.get(hold);
			}

			if (obj.nodeMap.get(required) == null && required != -1) {
				requireNode = new Node(required);
				obj.nodeMap.put(required, requireNode);
			} else if (required != -1) {
				requireNode = obj.nodeMap.get(required);
			}

			if (processNode != null && holdNode!=null && !processNode.toList.contains(holdNode)) {
				processNode.toList.add(holdNode);
			}

			if (requireNode != null && processNode!=null && !requireNode.toList.contains(processNode)) {
				requireNode.toList.add(processNode);
			}

			if (processNode != null && !obj.graph.contains(processNode)) {
				obj.graph.add(processNode);
			}
			if (requireNode != null && !obj.graph.contains(requireNode)) {
				obj.graph.add(requireNode);
			}
		}

		// obj.dfs(graph.ge);
		System.out.println(obj.dfs());
	}

}

class Node {
	int data;
	List<Node> toList;

	public Node(int data) {
		this.data = data;
		toList = new ArrayList<>();
	}
}