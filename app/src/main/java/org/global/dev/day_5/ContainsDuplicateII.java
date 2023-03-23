package org.global.dev.day_5;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
	
	static public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			} else {
				if (i - map.get(nums[i]) <= k) return true;
				else map.put(nums[i], i);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[]{99, 99}, 2));
	}
}
