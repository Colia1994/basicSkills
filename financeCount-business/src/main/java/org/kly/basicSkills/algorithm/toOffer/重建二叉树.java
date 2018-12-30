package org.kly.basicSkills.algorithm.toOffer;


/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author colia
 * @date 2018/12/30 17:54
 */
public class 重建二叉树 {

    /**
     * 基于不额外创建数组
     */
    private static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        reConstructBinaryTree(root, pre, in, 0, 0, pre.length);
        return root;
    }


    /**
     * 核心递归方法
     * @param root 当前节点
     * @param pre 完整前序数组
     * @param in 完整中序数组
     * @param indexP 本次递归前序开始下标
     * @param start 本次递归中序开始下标
     * @param length 本次递归数组长度
     */
    private static void reConstructBinaryTree(TreeNode root, int[] pre, int[] in, int indexP ,int start, int length) {
        int index = findIndex(pre[indexP], start, in);
        if (indexP + 1 < pre.length && index > 0) {
            root.left = new TreeNode(pre[indexP + 1]);
        }
        if (indexP + index + 1 < pre.length && length - index - 1 > 0) {
            root.right = new TreeNode(pre[indexP + index + 1]);
        }
        if (root.left != null) {
            reConstructBinaryTree(root.left, pre, in, indexP + 1, start, index);
        }
        if (root.right != null) {
            reConstructBinaryTree(root.right, pre, in, indexP + index + 1, start + index + 1, length - index - 1);
        }
    }

    private static int findIndex(int cur, int start, int[] in) {
        int result = 0;
        for (int i = start; i < in.length; i++) {
            if (in[i] == cur) {
                return result;
            } else {
                result++;
            }
        }
        return result;
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        reConstructBinaryTree(pre, in);
    }
}
