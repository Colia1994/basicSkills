package org.kly.basicSkills.algorithm.leetcode.easy;

import org.kly.common.TreeNode;

import java.util.Stack;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * @Author Colia
 * @Date 2020/3/13.
 */
public class e_面试题27_二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rightTree = mirrorTree(root.left);
        TreeNode leftTree = mirrorTree(root.right);
        root.right = rightTree;

        root.left = leftTree;
        return root;
    }




    //非递归实现
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode now = stack.pop();
            if (now.left != null) {
                stack.add(now.left);
            }
            if (now.right != null) {
                stack.add(now.right);
            }
            TreeNode c = now.left;
            now.left = now.right;
            now.right = c;
        }

        return root;
    }
}
