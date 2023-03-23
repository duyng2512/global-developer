package org.global.dev.day_5;

import java.util.HashMap;

public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> resultMap = new HashMap<>();
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (resultMap.containsKey(target - nums[i])) {
				result[0] = i;
				result[1] = resultMap.get(target - nums[i]);
				break;
			}
			resultMap.put(nums[i], i);
		}
		return result;
	}
	
}
