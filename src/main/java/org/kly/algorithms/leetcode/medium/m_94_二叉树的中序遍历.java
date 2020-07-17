package org.kly.algorithms.leetcode.medium;

import org.kly.infrastructure.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/6
 */
public class m_94_二叉树的中序遍历 {
    //迭代实现 借助队列
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        //
        boolean visitLeft = true;
        while (!deque.isEmpty()) {
            //访问全部左
            TreeNode node = deque.peek();
            while (visitLeft && node.left != null) {
                deque.addFirst(node.left);
                node = node.left;
            }
            node = deque.pop();
            res.add(node.val);
            visitLeft = false;
            //所有左子树和当前节点访问过后 将右子树加入队列
            if (node.right != null) {
                deque.addFirst(node.right);
                visitLeft = true;
            }
        }

        return res;
    }

    //递归实现
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
}
