package org.global.dev.day_5;

import java.util.Arrays;

public class TwoSumII {
	
	/**
	 * Two Sum II - Input Array Is Sorted
	 * Constant space
	 *
	 * @param numbers
	 * @param target
	 * @return
	 */
	static public int[] twoSum(int[] numbers, int target) {
		int low = 0, high = numbers.length - 1;
		
		while (low <= high) {
			
			int curSum = numbers[low] + numbers[high];
			
			if (curSum == target) {
				return new int[]{low + 1, high + 1};
			} else if (curSum < target) {
				low ++;
			} else {
				high --;
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{3, 24, 50, 79, 88, 150, 345}, 200)));
	}
}
