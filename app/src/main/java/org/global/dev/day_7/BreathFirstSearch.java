package org.global.dev.day_7;

import java.util.*;

public class BreathFirstSearch {
	
	/**
	 * https://leetcode.com/explore/featured/card/graph/619/depth-first-search-in-graph/3893/
	 *
	 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
	 * Output: true
	 * Explanation: There are two paths from vertex 0 to vertex 2:
	 * - 0 → 1 → 2
	 * - 0 → 2
	 *
	 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
	 * Output: false
	 * Explanation: There is no path from vertex 0 to vertex 5.
	 *
	 * Step to handle DFS problems
	 * 1. Form adjacency list
	 * 2. Perform DFS
	 */
	
	// Space O( m + n )
	// Time O( m + n )
	public boolean validPathBFS(int n, int[][] edges, int source, int destination) {
		
		// Form adjacency list
		Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
		for (int[] edge : edges) {
			int a = edge[0], b = edge[1];
			adjacencyList.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
			adjacencyList.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
		}
		
		// Construct seen array
		boolean[] seen = new boolean[n];
		seen[source] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(source);
		
		while (!queue.isEmpty()) {
		
			int curNode = queue.poll();
			if (curNode == destination) {
				return true;
			}
			
			// Transverse all adjacency node
			for(int next : adjacencyList.get(curNode)) {
				if (!seen[next]) {
					seen[next] = true;
					queue.offer(next);
				}
			}
		}
		
		return false;
	}
	
}
