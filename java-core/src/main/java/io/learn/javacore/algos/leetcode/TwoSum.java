package io.learn.javacore.algos.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        return result;
    }

    public int[] twoSumOptimized(int[] nums, int target) {
        Map<Integer, Integer> diffStorage = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (diffStorage.containsKey(difference)) {
                return new int[]{diffStorage.get(difference), i};
            } else {
                diffStorage.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
