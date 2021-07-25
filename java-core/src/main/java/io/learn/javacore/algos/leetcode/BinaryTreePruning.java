package io.learn.javacore.algos.leetcode;

public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private boolean containsOne(TreeNode node) {
        if (node == null) return false;
        boolean leftContains = containsOne(node.left);
        boolean rightContains = containsOne(node.right);
        if (!leftContains) {
            node.left = null;
        }
        if (!rightContains) {
            node.right = null;
        }

        return node.val == 1 || leftContains || rightContains;
    }

}
