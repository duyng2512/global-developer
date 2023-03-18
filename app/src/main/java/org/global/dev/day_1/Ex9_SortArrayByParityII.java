package org.global.dev.day_1;

/**
 * @author duyntc 02/2023
 */
public class Ex9_SortArrayByParityII {
	
	static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
	
	/**
	 * https://leetcode.com/problems/sort-array-by-parity-ii/
	 * Time: O(n)
	 * Space: O(1)
	 */
	
	public int[] sortArrayByParityII(int[] nums) {
		int pivot = 1;
		for (int i = 0; i < nums.length; i += 2) {
			if (nums[i] % 2 == 1) { // Odd wrong place
				// Find the right place for i
				// If the next still odd then increase
				while (nums[pivot] % 2 == 1) {
					pivot += 2;
				}
				swap(nums, i, pivot);
			}
		}
		
		return nums;
	}
}
