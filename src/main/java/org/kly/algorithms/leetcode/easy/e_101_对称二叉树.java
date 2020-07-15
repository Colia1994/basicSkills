package org.kly.algorithms.leetcode.easy;

import org.kly.common.TreeNode;

/**
 * 101. Symmetric tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *
 * @author colia
 * @date 2018/12/25 21:34
 */
public class e_101_对称二叉树 {


    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        return root1 == null && root2 == null
                || !(root1 == null || root2 == null)
                && root1.val == root2.val
                && isSymmetric(root1.left, root2.right)
                && isSymmetric(root1.right, root2.left);
    }

}
