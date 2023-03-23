package org.global.dev.day_3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
	
	// https://leetcode.com/problems/sliding-window-maximum/
	
	
	/**
	 * Example 1:
	 * <p>
	 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
	 * Output: [3,3,5,5,6,7]
	 * Explanation:
	 * Window position                Max
	 * ---------------               -----
	 * [1  3  -1] -3  5  3  6  7       3
	 * 1 [3  -1  -3] 5  3  6  7       3
	 * 1  3 [-1  -3  5] 3  6  7       5
	 * 1  3  -1 [-3  5  3] 6  7       5
	 * 1  3  -1  -3 [5  3  6] 7       6
	 * 1  3  -1  -3  5 [3  6  7]      7
	 * Example 2:
	 * <p>
	 * Max 3
	 * <p>
	 * Input: nums = [1], k = 1
	 * Output: [1]
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	
	// Heap Result in time limit exceed ???
	// Time = O(NlogN)
	static public int[] maxSlidingWindow(int[] nums, int k) {
		
		PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
		
		for (int i = 0; i < k; i++) {
			heap.add(nums[i]);
		}
		
		int[] result = new int[nums.length - k + 1];
		
		for (int i = k; i < nums.length; i++) {
			result[i - k] = heap.peek();
			heap.remove(nums[i - k]);
			heap.add(nums[i]);
		}
		result[nums.length - k] = heap.peek();
		return result;
	}
	
	static public void removeLeastThanN(int[] nums, int i, int k, Deque<Integer> deque) {
		
		// Trim the previous part
		// Example: 1 [2 3 -8] 5 6 10 --> Trim 1 when k = 3
		while (!deque.isEmpty() && deque.getFirst() == i - k) {
			deque.removeFirst();
		}
		
		// Trim all that less than num[i]
		while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
			deque.removeLast();
		}
	}
	
	static public int[] maxSlidingWindowDeque(int[] nums, int k) {
		
		// Edge case
		int n = nums.length;
		if (n * k == 0) return new int[0];
		if (k == 1) return nums;
		
		
		Deque<Integer> deque = new ArrayDeque<>();
		int maxIdx = 0;
		
		for (int i = 0; i < k; i++) {
			removeLeastThanN(nums, i, k, deque);
			deque.addLast(i);
			if (nums[i] > nums[maxIdx]) maxIdx = i;
		}
		
		int[] result = new int[nums.length - k + 1];
		result[0] = nums[maxIdx];
		
		for (int i = k; i < nums.length; i++) {
			removeLeastThanN(nums, i, k, deque);
			deque.addLast(i);
			result[i - k + 1] = nums[deque.getFirst()];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = maxSlidingWindowDeque(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
		System.out.println(Arrays.toString(arr)); //  3 3 5 5 6 7
	}
	
}
