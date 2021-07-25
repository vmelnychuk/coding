package io.learn.javacore.algos.leetcode;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    private int[] originalArray;
    private Random random = new Random();

    public ShuffleAnArray(int[] nums) {
        this.originalArray = nums;
    }

    public int[] reset() {
        return originalArray;
    }

    public int[] shuffle() {
        int[] copyOfArray = Arrays.copyOf(originalArray, originalArray.length);
        for (int i = originalArray.length; i > 1; i--) {
            swap(copyOfArray, i - 1, random.nextInt(i));
        }
        return copyOfArray;
    }

    private void swap(int[] array, int fistIndex, int secondIndex) {
        int temp = array[fistIndex];
        array[fistIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
