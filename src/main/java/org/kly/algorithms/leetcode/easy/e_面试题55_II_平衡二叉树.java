package org.kly.algorithms.leetcode.easy;

import org.kly.common.TreeNode;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 *  
 *
 * @Author Colia
 * @Date 2020/3/15.
 */
public class e_面试题55_II_平衡二叉树 {


    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return flag;

    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int ld = depth(node.left);
        int rd = depth(node.right);
        if (Math.abs(ld - rd) > 1) {
            flag = false;
        }

        return Math.max(ld, rd) + 1;
    }

}
