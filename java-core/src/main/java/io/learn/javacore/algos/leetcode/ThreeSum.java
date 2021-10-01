package io.learn.javacore.algos.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum1(int[] nums) {
        final int desiredSum = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 1; j < nums.length - 1; j++) {
                for (int k = 2; k < nums.length; k++) {
                    if (i != j && j != k && k != i) {
                        if ((nums[i] + nums[j] + nums[k]) == desiredSum) {
                            List<Integer> num = Arrays.asList(nums[i], nums[j], nums[k]);
                            Collections.sort(num);
                            if (!result.contains(num)) {
                                result.add(num);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        final int desiredSum = 0;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > desiredSum) {
                    right--;
                } else if (sum < desiredSum) {
                    left++;
                } else {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    while (nums[left] == nums[left -1] && left < right) {
                        left++;
                    }
                }
            }
        }

        return result;
    }
}
