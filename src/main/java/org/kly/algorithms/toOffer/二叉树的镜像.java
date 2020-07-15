package org.kly.algorithms.toOffer;

import org.kly.common.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 *
 * @author colia
 * @date 2018/12/30 23:17
 */
public class 二叉树的镜像 {

    public void Mirror(TreeNode root) {

        if (root == null) {
            return;
        }
        TreeNode newNode = root.left;
        root.left = root.right;
        root.right = newNode;
        Mirror(root.left);
        Mirror(root.right);

    }

}
