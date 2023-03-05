package org.global.dev.day_5;

import java.util.*;

public class ThreeSum {
	
	// -1,0,1,2,-1,-4
	// -1 0
	// -1   1
	// complement = 1 hash = [0]
	// complement = 0 hash = [0, 1] => result = [-1, 0, 1]
	// complement = -1 hash = [0, 1, 2]
	// complement = -2 hash = [0, 1, 2, -1]
	
	static public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				twoSumHashSet(result, i, nums);
			}
		}
		return result;
	}
	
	static public void twoSumHashSet(List<List<Integer>> result, int i, int[] nums) {
		Set<Integer> seen = new HashSet<>();
		for (int j = i + 1; j < nums.length; j++) {
			int require = -nums[i] - nums[j];
			if (seen.contains(require)) {
				
				List<Integer> list = new ArrayList<>(List.of(nums[i], nums[j], require));
				Collections.sort(list);
				result.add(list);
				
				while (j + 1 < nums.length && nums[j] == nums[j + 1])
					++j; // Avoid duplicate
			}
			seen.add(nums[j]);
		}
	}
	
	
	// -1, 0, 1, 2, -1, -4
	static public List<List<Integer>> threeSumNoSort(int[] nums) {
		
		Set<List<Integer>> res = new HashSet<>();
		Set<Integer> dup = new HashSet<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (dup.add(nums[i])) {
				
				int target = -nums[i]; //
				
				// Now is two sum
				HashMap<Integer, Integer> seen = new HashMap<>();
				for (int j = i + 1; j < nums.length; j++) {
					if (seen.containsKey(target - nums[j])) {
						List<Integer> list = new ArrayList<>(List.of(nums[i], nums[j], nums[seen.get(target - nums[j])]));
						Collections.sort(list);
						res.add(list);
					}
					seen.put(nums[j], j);
				}
			}
			
		}
		return new ArrayList<>(res);
	}
	
	public static void main(String[] args) {
		System.out.println(threeSumNoSort(new int[]{-1, 0, 1, 2, -1, -4}));
	}
}
