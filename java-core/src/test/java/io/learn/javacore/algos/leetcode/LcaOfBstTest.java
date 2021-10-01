package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LcaOfBstTest {

    @Test
    void lowestCommonAncestorFor_6_2_8_WithRecursion() {
        LcaOfBst lcaOfBst = new LcaOfBst();
        TreeNode root = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        root.left = two;
        root.right = eight;
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        two.left = zero;
        two.right = four;
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        four.left = three;
        four.right = five;
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        eight.left = seven;
        eight.right = nine;

        TreeNode lca = lcaOfBst.lowestCommonAncestorRecursion(root, two, eight);

        assertEquals(6, lca.val);
    }

    @Test
    void lowestCommonAncestor_6_2_4_WithRecursion() {
        LcaOfBst lcaOfBst = new LcaOfBst();
        TreeNode root = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        root.left = two;
        root.right = eight;
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        two.left = zero;
        two.right = four;
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        four.left = three;
        four.right = five;
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        eight.left = seven;
        eight.right = nine;

        TreeNode lca = lcaOfBst.lowestCommonAncestorRecursion(root, two, four);

        assertEquals(2, lca.val);
    }

    @Test
    void lowestCommonAncestorFor_6_2_8_WithIteration() {
        LcaOfBst lcaOfBst = new LcaOfBst();
        TreeNode root = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        root.left = two;
        root.right = eight;
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        two.left = zero;
        two.right = four;
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        four.left = three;
        four.right = five;
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        eight.left = seven;
        eight.right = nine;

        TreeNode lca = lcaOfBst.lowestCommonAncestorIterative(root, two, eight);

        assertEquals(6, lca.val);
    }

    @Test
    void lowestCommonAncestor_6_2_4_WithIteration() {
        LcaOfBst lcaOfBst = new LcaOfBst();
        TreeNode root = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        root.left = two;
        root.right = eight;
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        two.left = zero;
        two.right = four;
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        four.left = three;
        four.right = five;
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        eight.left = seven;
        eight.right = nine;

        TreeNode lca = lcaOfBst.lowestCommonAncestorIterative(root, two, four);

        assertEquals(2, lca.val);
    }
}
