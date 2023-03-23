package org.global.dev.day_7.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {
	
	int[][] offsets = {{1, 2}, {2, 1}, {2, -1}, {1, -2},
					{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
	
	public int minKnightMoves(int x, int y) {
		Set<Integer> visited = new HashSet<>();
		int[] root = new int[]{0, 0};
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(root);
		int steps = 0;
		
		while (!queue.isEmpty()) {
			int curSize = queue.size();
			
			for (int i = 0; i < curSize; i++) {
				int[] curNode = queue.poll();
				
				if (curNode[0] == x && curNode[1] == y) return steps;
				
				for (int[] offset : offsets) {
					int newX = curNode[0] + offset[0];
					int newY = curNode[1] + offset[1];
					
					Integer cor = newX*1000 + newY;
					if (!visited.contains(cor)) {
						queue.offer(new int[]{newX, newY});
						visited.add(cor);
					}
				}
			}
			steps += 1;
		}
		return -1;
	}
	
}
