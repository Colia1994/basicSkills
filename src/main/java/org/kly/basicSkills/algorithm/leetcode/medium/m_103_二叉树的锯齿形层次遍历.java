package org.kly.basicSkills.algorithm.leetcode.medium;

import org.kly.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/6
 */
public class m_103_二叉树的锯齿形层次遍历 {

    public List<List<Integer>> zigzagLevelOrderBFSMine(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }
        LinkedList<Integer> cellNum = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<Integer> dequeDep = new LinkedList<>();
        deque.addFirst(root);
        dequeDep.addFirst(0);
        int curDep = 0;
        boolean toRight = false;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            int dep = dequeDep.pop();

            if(node.left!=null) {
                deque.add(node.left);
                dequeDep.add(dep + 1);

            }
            if(node.right != null) {
                deque.add(node.right);
                dequeDep.add(dep + 1);

            }

            if (curDep != dep) {
                curDep = dep;
                toRight = !toRight;
                res.add(new ArrayList<>(cellNum));
                cellNum.clear();
            }
            if(toRight) {
                cellNum.addFirst(node.val);
            } else {
                cellNum.addLast(node.val);
            }
            if(deque.isEmpty()){
                res.add(new ArrayList<>(cellNum));

            }
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrderBFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> results = new ArrayList<>();

        // add the root element with a delimiter to kick off the BFS loop
        LinkedList<TreeNode> node_queue = new LinkedList<>();
        node_queue.addLast(root);
        node_queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<>();
        boolean is_order_left = true;

        while (node_queue.size() > 0) {
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                if (is_order_left)
                    level_list.addLast(curr_node.val);
                else
                    level_list.addFirst(curr_node.val);

                if (curr_node.left != null)
                    node_queue.addLast(curr_node.left);
                if (curr_node.right != null)
                    node_queue.addLast(curr_node.right);

            } else {
                // we finish the scan of one level
                results.add(level_list);
                level_list = new LinkedList<Integer>();
                // prepare for the next level
                if (node_queue.size() > 0)
                    node_queue.addLast(null);
                is_order_left = !is_order_left;
            }
        }
        return results;
    }

    protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
        if (level >= results.size()) {
            LinkedList<Integer> newLevel = new LinkedList<Integer>();
            newLevel.add(node.val);
            results.add(newLevel);
        } else {
            if (level % 2 == 0)
                results.get(level).add(node.val);
            else
                results.get(level).add(0, node.val);
        }

        if (node.left != null) DFS(node.left, level + 1, results);
        if (node.right != null) DFS(node.right, level + 1, results);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        DFS(root, 0, results);
        return results;
    }


    public static void main(String[] args){
        m_103_二叉树的锯齿形层次遍历 m = new m_103_二叉树的锯齿形层次遍历();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        m.zigzagLevelOrderBFS(node);
    }

}
