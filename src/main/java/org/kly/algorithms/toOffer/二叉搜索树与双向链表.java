package org.kly.algorithms.toOffer;

import org.kly.common.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * @author colia
 * @date 2019/1/1 19:09
 */
public class 二叉搜索树与双向链表 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(14);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        Convert(root);
    }


    public static TreeNode Convert(TreeNode pRootOfTree) {
        return Convert(pRootOfTree, null);

    }

    public static TreeNode Convert(TreeNode pRootOfTree, TreeNode node) {

        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.right != null) {
            node = Convert(pRootOfTree.right, node);
        }
        pRootOfTree.right = node;
        if (node != null) {
            node.left = pRootOfTree;
        }
        node = pRootOfTree;
        if (pRootOfTree.left != null) {

            node = Convert(pRootOfTree.left, node);
        }
        return node;

    }


}