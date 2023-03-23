package org.global.dev.day_7.bfs;

import java.util.*;

public class MinimumGeneticMutation {
	
	public static void main(String[] args) {
		MinimumGeneticMutation min = new MinimumGeneticMutation();
		int res = min.minMutation("AAAACCCC", "CCCCCCCC", new String[]{"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"});
		System.out.println(res);
	}
	
	boolean isMutation(String gene1, String gene2) {
		int count = 0;
		for (int i = 0; i < gene1.length(); i++) {
			if (gene1.charAt(i) != gene2.charAt(i)) {
				count++;
			}
		}
		return count == 1;
	}
	
	public List<String> getMutation(String[] bank, String gene, Set<String> visited) {
		List<String> list = new ArrayList<>();
		for (String s : bank) {
			if (!visited.contains(s) && isMutation(gene, s)) {
				list.add(s);
			}
		}
		return list;
	}
	
	public int minMutation(String startGene, String endGene, String[] bank) {
		Queue<String> queue = new ArrayDeque<>();
		Set<String> visited = new HashSet<>();
		visited.add(startGene);
		queue.offer(startGene);
		int count = 0;
		
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			
			List<String> mutations = getMutation(bank, cur, visited);
			if (!mutations.isEmpty()) count++;
			
			
			System.out.println("Cur " + cur);
			System.out.println("Mu " + mutations);
			System.out.println("------");
			
			for (String mutation : mutations) {
				if (mutation.equals(endGene)) return count;
				queue.offer(mutation);
				visited.add(mutation);
			}
			
		}
		return -1;
	}
	
}
