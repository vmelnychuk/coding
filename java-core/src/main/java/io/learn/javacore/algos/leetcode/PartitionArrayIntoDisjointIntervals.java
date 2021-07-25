package io.learn.javacore.algos.leetcode;

public class PartitionArrayIntoDisjointIntervals {

    public int partitionDisjoint1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                left++;
                right--;
            } else if (nums[left] > nums[right]) {
                left = right;
                break;
            }
        }
        return left + 1;
    }

    public int partitionDisjoint(int[] nums) {
        int max = nums[0];
        int maxInLeft = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < maxInLeft) {
                maxInLeft = max;
                index = i;
            }
        }
        return index + 1;
    }
}
