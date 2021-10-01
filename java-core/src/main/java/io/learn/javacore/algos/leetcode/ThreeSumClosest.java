package io.learn.javacore.algos.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[nums.length -1];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int current = nums[i] + nums[start] + nums[end];
                if (current > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(current - target) < Math.abs(closestSum - target)) {
                    closestSum = current;
                }
            }
        }
        return closestSum;
    }
}
