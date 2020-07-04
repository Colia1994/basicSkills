package org.kly.basicSkills.algorithm.leetcode.easy;

import org.kly.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * 案例 1:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * 输出: True
 *  
 * <p>
 * 案例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/4
 */
public class e_653两数之和IV输入BST {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> ints = new ArrayList<>();
        Deque<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.addFirst(root);
        //队列首个元素是否需要向左一直遍历左子节点
        boolean isVisitedLeft = false;
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.peek();
            while (!isVisitedLeft && node != null && node.left != null) {
                treeNodes.addFirst(node.left);
                node = node.left;
            }
            node = treeNodes.pop();
            ints.add(node.val);
            isVisitedLeft = true;
            if (node.right != null) {
                treeNodes.addFirst(node.right);
                isVisitedLeft = false;
            }

        }
        int i = 0, j = ints.size() - 1;
        while (i < j) {
            if (ints.get(i) + ints.get(j) > k) {
                j--;
            } else if (ints.get(i) + ints.get(j) < k) {
                i++;
            } else {
                return true;
            }
        }

        return false;
    }
}
