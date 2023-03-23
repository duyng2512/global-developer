package org.global.dev.day_3;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {
	
	/**
	 * Example 1:
	 * <p>
	 * Input: s = "abcd", k = 2
	 * Output: "abcd"
	 * Explanation: There's nothing to delete.
	 * Example 2:
	 * <p>
	 * Input: s = "deeedbbcccbdaa", k = 3
	 * Output: "aa"
	 * Explanation:
	 * First delete "eee" and "ccc", get "ddbbbdaa"
	 * Then delete "bbb", get "dddaa"
	 * Finally delete "ddd", get "aa"
	 *
	 *
	 * Idea: keep a stack of
	 */
	
	static public String removeDuplicates(String s, int k) {
		Stack<Integer> stack = new Stack<>();
		
		Character prev = s.charAt(0);
		stack.add(1);
		
		StringBuilder builder = new StringBuilder();
		builder.append(prev);
		
		for (int i = 1; i < s.length(); i++) {
			Character cur = s.charAt(i);
			builder.append(cur);
			
			
			if (!cur.equals(prev)) {
				stack.add(1);
				prev = cur;
			} else {
				int pop = stack.pop();
				stack.add(pop + 1);
				// Update last index
				if (pop + 1 == k) {
					stack.pop();
					builder = new StringBuilder(builder.substring(0, builder.length() - k));
					if (builder.length() >= 1) {
						prev = builder.charAt(builder.length() - 1);
					} else {
						prev = '@'; // in case of nothing
					}
				}
				;
			}
		}
		return builder.toString();
	}
	
}
