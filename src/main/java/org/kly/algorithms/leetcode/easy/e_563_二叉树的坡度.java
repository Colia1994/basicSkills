package org.kly.algorithms.leetcode.easy;

import org.kly.common.TreeNode;

/**
 * 给定一个二叉树，计算整个树的坡度。
 * <p>
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * <p>
 * 整个树的坡度就是其所有节点的坡度之和。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * 1
 * /   \
 * 2     3
 * 输出：1
 * 解释：
 * 结点 2 的坡度: 0
 * 结点 3 的坡度: 0
 * 结点 1 的坡度: |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/3
 */
public class e_563_二叉树的坡度 {


    int tilt = 0;

    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }

    public int traverse(TreeNode root) {
        if (root == null)
            return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }


}
