package io.learn.javacore.algos.leetcode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return constructTreeFromArray(nums, 0, nums.length-1);
    }

    private TreeNode constructTreeFromArray(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int minPoint = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[minPoint]);
        node.left = constructTreeFromArray(nums, left, minPoint - 1);
        node.right = constructTreeFromArray(nums, minPoint + 1, right);
        return node;
    }
}
