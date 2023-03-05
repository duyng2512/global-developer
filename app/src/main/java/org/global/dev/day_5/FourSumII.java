package org.global.dev.day_5;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
	
	/**
	 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
	 * Output: 2
	 * Explanation:
	 * The two tuples are:
	 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
	 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
	 * <p>
	 * Idea: From first two array create map of sum -> index, from second array create map of sum -> index
	 * Loop through two map to find a pair of sum1 + sum2 = 0
	 * <p>
	 * Follow up: ? six sum, eight sum, ten sum ....
	 * Divide into 3 vs 3 , 4 vs 4, 5 vs 5 array and create hash map sum of them, and similar to 4sumII
	 * just have to make a final loop through them again. Time complexity O(N ^ (k/2))
	 * <p>
	 * <p>
	 * 1  2
	 * -2 -1
	 * <p>
	 * -1: (0, 0)
	 * 0: (0, 1), (1,0)
	 * 1: (1,1)
	 * <p>
	 * -1  2
	 * 0  2
	 * -1: (0,0)
	 * 1: (0,1)
	 * 2: (1,0)
	 * 4: (1,1)
	 * <p>
	 * create hash map M (key = sum arr1[] arr2[], value = list of index)
	 * -1: index 0 0
	 * 0: index 0,1
	 * 0: index 1,0
	 * 1: index 1,1
	 * <p>
	 * -1 2
	 * 0 2
	 * 0,0 : sum = -1: ? there is 1 exist in map ? yes add to result map(1) + 0,0
	 * ...
	 */
	
	static public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int N = nums1.length;
		Map<Integer, Integer> map1 = new HashMap<>();
		
		for (int k : nums1) {
			for (int j = 0; j < N; j++) {
				int sum = k + nums2[j];
				
				if (map1.containsKey(sum)) {
					map1.put(sum, map1.get(sum) + 1);
				} else {
					map1.put(sum, 1);
				}
			}
		}
		
		Map<Integer, Integer> map2 = new HashMap<>();
		
		for (int k : nums3) {
			for (int j = 0; j < N; j++) {
				int sum = k + nums4[j];
				
				if (map2.containsKey(sum)) {
					map2.put(sum, map2.get(sum) + 1);
				} else {
					map2.put(sum, 1);
				}
			}
		}
		
		int result = 0;
		
		for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
			int sum = entry.getKey();
			int freq = entry.getValue();
			if (map2.containsKey(-sum)) {
				result = result + (freq * map2.get(-sum));
			}
		}
		return result;
	}
	
	static public int fourSumCountV2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int M = nums1.length;
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int k : nums1) {
			for (int j = 0; j < M; j++) {
				int sum = k + nums2[j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		int result = 0;
		for (int k : nums3) {
			for (int j = 0; j < M; j++) {
				int sum = k + nums4[j];
				result += map.getOrDefault(-sum, 0);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
		System.out.println(fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}));
	}
	
}
