package org.kly.algorithms.leetcode.easy;


import org.kly.infrastructure.common.TreeNode;

public class e_226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;

    }
}
