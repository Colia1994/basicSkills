package org.kly.algorithms.leetcode.medium;

import org.kly.infrastructure.common.TreeNode;

/**
 * @author konglingyao
 * @date 2024/7/25
 */
public class m_298 {

    int maxLong = 0;

    public int longestConsecutive(TreeNode root) {
        longestConsecutive_digui(root);

        return maxLong;
    }

    public int longestConsecutive_digui(TreeNode root) {
        if (root == null) return 0;
        int leftLong = longestConsecutive_digui(root.left);
        int rightLong = longestConsecutive_digui(root.right);

        int max = 1;
        if (root.left != null && root.val == root.left.val - 1) {
            max = Math.max(max, 1 + leftLong);
        }
        if (root.right != null && root.val == root.right.val - 1) {
            max = Math.max(max, 1 + rightLong);
        }
        maxLong = Math.max(max, maxLong);

        return max;

    }


    int maxLength = 0;

    public int longestConsecutive1(TreeNode root) {
        dfs(root);
        return maxLength;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int length = 1;
        int leftLength = dfs(node.left);
        int rightLength = dfs(node.right);
        if (node.left != null && node.left.val - node.val == 1) {
            length = Math.max(length, leftLength + 1);
        }
        if (node.right != null && node.right.val - node.val == 1) {
            length = Math.max(length, rightLength + 1);
        }
        maxLength = Math.max(maxLength, length);
        return length;
    }
}
