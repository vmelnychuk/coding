package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreePruningTest {
    private BinaryTreePruning binaryTreePruning = new BinaryTreePruning();

    @BeforeEach
    void setUp() {
    }

    @Test
    void pruneTreeEx1() {
        TreeNode input = new TreeNode(1, null, new TreeNode(0, new TreeNode(0), new TreeNode(1)));

        TreeNode result = binaryTreePruning.pruneTree(input);

        assertNull(result.right.left);
    }

    @Test
    void pruneTreeEx2() {
        TreeNode input = new TreeNode(1,
            new TreeNode(0, new TreeNode(0), new TreeNode(0)),
            new TreeNode(1, new TreeNode(0), new TreeNode(1)));

        TreeNode result = binaryTreePruning.pruneTree(input);

        assertNull(result.left);
        assertNull(result.right.left);
    }
}
