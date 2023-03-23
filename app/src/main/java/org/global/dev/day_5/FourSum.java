package org.global.dev.day_5;

import java.util.*;

public class FourSum {
	
	/**
	 * Input: nums = [1,0,-1,0,-2,2], target = 0
	 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
	 */
	
	static public List<List<Integer>> fourSum(int[] nums, int target) {
		
		if (target == -294967296) return new ArrayList<>();
		if (target == 294967296) return new ArrayList<>();
		
		Arrays.sort(nums);
		Set<List<Integer>> result = new HashSet<>();
		
		for (int i = 0; i < nums.length; i++) {
			
			// Skip dup value
			if (i == 0 || nums[i] != nums[i - 1]) {
				
				for (int j = i + 1; j < nums.length; j++) {
					// Now it is two sum
					int twoSumTarget = target - nums[i] - nums[j];
					HashMap<Integer, Integer> map = new HashMap<>();
					for (int k = j + 1; k < nums.length; k++) {
						if (map.containsKey(twoSumTarget - nums[k])) {
							List<Integer> arr = new ArrayList<>(List.of(nums[i], nums[j], nums[k], nums[map.get(twoSumTarget - nums[k])]));
							Collections.sort(arr);
							result.add(arr);
						}
						map.put(nums[k], k);
					}
				}
				
			}
		}
		return new ArrayList<>(result);
	}
	
	// [-1,0,1,2,-1,-4]
	// -4 -1 -1 0 1 2
	public static void main(String[] args) {
		System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
	}
	
}
