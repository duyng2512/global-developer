package org.global.dev.day_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheKStrongestValuesInAnArray {
	
	public static void main(String[] args) {
		TheKStrongestValuesInAnArray anArray = new TheKStrongestValuesInAnArray();
		System.out.println(Arrays.toString(anArray.getStrongest(new int[]{1, 1, 3, 5, 5}, 2)));
	}
	
	static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
	
	public int[] getStrongest(int[] arr, int k) {
		int median = median(arr);
		int[] strong = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			strong[i] = Math.abs(arr[i] - median);
		}
		System.out.println(Arrays.toString(strong));
		int kThStrongest = selectStrong(strong, 0, arr.length - 1, k);
		System.out.println(kThStrongest);
		List<Integer> list = new ArrayList<>();
		
		for (int i = arr.length - 1; i >= 0; i--) {
			if (k == 0) break;
			
			int strongLevel = Math.abs(arr[i] - median);
			if (strongLevel >= kThStrongest) {
				list.add(arr[i]);
				k--;
			}
		}
		
		int[] result = new int[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		
		return result;
		
	}
	
	public int selectStrong(int[] arr, int begin, int end, int k) {
		
		if (begin == end) {
			return arr[begin];
		}
		
		int partition = partition(arr, begin, end);
		
		if (partition == k - 1) {
			return arr[partition];
		} else if (partition < k - 1) {
			return selectStrong(arr, partition + 1, end, k);
		} else {
			return selectStrong(arr, begin, partition - 1, k);
		}
		
	}
	
	public int partition(int[] arr, int begin, int end) {
		int loc = begin;
		int val = arr[end];
		
		for (int i = begin; i < end; i++) {
			if (arr[i] > val) {
				swap(arr, loc, i);
				loc++;
			}
	}
	
	swap(arr, end, loc);
	
	return loc;
     }
     
     // 1, 2, 3, 4, 5
     public int median(int[] arr) {
	int mid = arr.length / 2;
	if (arr.length % 2 == 1) {
	     return arr[mid];
	} else {
	     return (arr[mid] + arr[mid - 1]) / 2;
	}
     }
}
