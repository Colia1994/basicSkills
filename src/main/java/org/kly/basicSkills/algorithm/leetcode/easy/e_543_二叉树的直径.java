package org.kly.basicSkills.algorithm.leetcode.easy;

import org.kly.common.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * @Author Colia
 * @Date 2020/3/10.
 */
public class e_543_二叉树的直径 {


    int ans = 1;


    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = depth(node.left);
        int r = depth(node.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;

    }


}
