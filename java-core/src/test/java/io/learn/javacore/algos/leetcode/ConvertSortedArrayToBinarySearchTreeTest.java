package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ConvertSortedArrayToBinarySearchTreeTest {

    private ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();

    @Test
    void sortedArrayToBSTEx1() {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = convertSortedArrayToBinarySearchTree.sortedArrayToBST(nums);

        assertEquals(0, treeNode.val);
        assertEquals(-10, treeNode.left.val);
        assertEquals(5, treeNode.right.val);
    }

    @Test
    void sortedArrayToBSTEx2() {
        int[] nums = new int[]{1, 3};
        TreeNode treeNode = convertSortedArrayToBinarySearchTree.sortedArrayToBST(nums);

        assertEquals(1, treeNode.val);
        assertEquals(3, treeNode.right.val);
    }
}
