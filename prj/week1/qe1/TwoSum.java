package leetcode;

import java.util.Arrays;

public class TwoSum {
	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int[] nums = { 2, 7, 11, 15 };
		System.out.println(Arrays.toString(twoSum.twoSum(nums, 9)));
	}

	/**
	 * Runtime: 56 ms, faster than 30.87% of Java online submissions for Two Sum.
	 * Memory Usage: 39.6 MB, less than 47.63% of Java online submissions for Two Sum.
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target)
					return new int[] { i, j };
			}
		}
		return null;
	}
}
