package org.kly.algorithms.leetcode.medium;

import org.kly.infrastructure.common.TreeNode;

/**
 * @author konglingyao
 * @date 2024/7/16
 */
public class m_669 {


    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null){
            return null;
        }


        TreeNode left = trimBST(root.left, low, high);
        TreeNode right = trimBST(root.right, low, high);

        if(root.val < low || root.val > high){
            //修建 n 此时n的 left一定不符合 被删光了。right 可能还有
            if(left == null)
                return right;
            if(right == null)
                return left;
            return root;
        }

        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);

        m_669 tree = new m_669();
        tree.trimBST(root, 1, 2);
    }


}


