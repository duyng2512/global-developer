package org.global.dev.common;

public class MergeTwoSortedArr {
     
     /**
      * 1 2 3 0 0 0
      * 2 5 6
      * <p>
      * 1 2 3 0 0 6
      * 2 5
      * <p>
      * 1 2 3 0 5 6
      * 2
      * <p>
      * 1 2 0 3 5 6
      * 2
      * <p>
      * 1 2 2 3 5 6
      * <p>
      * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
      * <p>
      * Output: [1,2,2,3,5,6]
      * <p>
      * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
      * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
      *
      * @param nums1
      * @param m
      * @param nums2
      * @param n
      */
     
     static public void merge(int[] nums1, int m, int[] nums2, int n) {
	
	int p1 = m - 1;
	int p2 = n - 1;
	
	for (int i = m + n - 1; i >= 0; i--) {
	     
	     if (p2 < 0) break;
	     
	     if (p1 >= 0 && nums1[p1] > nums2[p2]) {
		nums1[i] = nums1[p1];
		p1--;
	     } else {
		nums1[i] = nums2[p2];
		p2--;
	     }
	}
	
     }
     
     static void swap(int[] arr, int first, int second) {
	int temp = arr[first];
	arr[first] = arr[second];
	arr[second] = temp;
     }
     
     public static void main(String[] args) {
	int[] arr1 = {1, 2, 3, 0, 0, 0};
	int[] arr2 = {2, 5, 6};
	
     }
     
}
