package org.kly.algorithms.leetcode.easy;

import org.kly.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/10
 */
public class e_111_二叉树的最小深度 {
    /**
     * bfs
     * 1234nn5
     * 1
     * 2-3
     * 4 n n 5
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        int depth = 1;
        while (!deque.isEmpty()) {
            //散开枝叶
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pop();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
