package io.learn.javacore.algos.leetcode;

public class LcaOfBst {

    public TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val >= p.val) && (root.val <= q.val) ||
            (root.val >= q.val) && (root.val <= p.val)) {
            return root;
        } else {
            if ((root.val > p.val) && (root.val > q.val)) {
                root = root.left;
            } else {
                root = root.right;
            }
            return lowestCommonAncestorRecursion(root, p, q);
        }
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if ((root.val >= p.val) && (root.val <= q.val) ||
                (root.val >= q.val) && (root.val <= p.val)) {
                break;
            } else if ((root.val > p.val) && (root.val > q.val)) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
