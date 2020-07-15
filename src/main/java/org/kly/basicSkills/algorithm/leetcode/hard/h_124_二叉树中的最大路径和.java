package org.kly.basicSkills.algorithm.leetcode.hard;

import org.kly.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * [5,4,8,11,null,13,4,7,2,null,null,null,1]
 *
 * @Author konglingyao
 * @Date 2020/7/6
 */
public class h_124_二叉树中的最大路径和 {


    public int maxPathSum(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        maxSumOfTree(root, res);
        int max = res.get(0);
        for (Integer i : res) {
            max = Math.max(i, max);
        }
        return max;

    }

    private int maxSumOfTree(TreeNode node, List<Integer> res) {
        if (node == null) {
            return 0;
        }
        int maxLeft = Math.max(maxSumOfTree(node.left, res), 0);
        int maxRight = Math.max(maxSumOfTree(node.right, res), 0);
        int nowSum = node.val + maxLeft + maxRight;
        res.add(nowSum);
        return node.val + Math.max(maxLeft, maxRight);
    }




}
