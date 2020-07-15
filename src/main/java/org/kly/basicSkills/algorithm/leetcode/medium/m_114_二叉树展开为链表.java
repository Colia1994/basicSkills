package org.kly.basicSkills.algorithm.leetcode.medium;

import org.kly.common.TreeNode;

/**
 * 114. FlattenBinaryTreetoLinkedList
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, given the following tree:
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 *
 * @author colia
 * @date 2018/12/13 0:16
 */
public class m_114_二叉树展开为链表 {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public void flatten(TreeNode root) {

        if (root != null) {
            change(root);
        }
    }

    private void change(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode next = root.left == null ? root.right : root.left;

        TreeNode downNode = root.left == null ? root : flattenAux(root.left);
        downNode.right = root.right;

        root.left = null;
        root.right = next;
        change(next);
    }

    /**
     * 找到最小右节点
     */
    private TreeNode flattenAux(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        //找到最小右节点
        TreeNode leftEnd = root.left == null ? root : flattenAux(root.left);
        return (root.right == null) ? leftEnd : flattenAux(root.right);

    }


    //参考答案
    TreeNode flattenAux1(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;


        TreeNode next = left == null ? right : left;

        TreeNode leftEnd = left == null ? root : flattenAux(left);
        TreeNode rightEnd = right == null ? leftEnd : flattenAux(right);

        leftEnd.right = right;

        //清空左子节点
        root.left = null;
        //更新右子节点
        root.right = next;

        return rightEnd;

    }


}
