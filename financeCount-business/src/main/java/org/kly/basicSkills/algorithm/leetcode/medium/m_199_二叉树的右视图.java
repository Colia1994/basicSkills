package org.kly.basicSkills.algorithm.leetcode.medium;

import org.kly.common.TreeNode;

import java.util.*;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/4
 */
public class m_199_二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        DepTreeNode depTreeNode = new DepTreeNode(root, 0);
        Deque<DepTreeNode> deque = new LinkedList<>();
        deque.add(depTreeNode);

        int curDepth = 0;
        int preVal = 0;
        List<Integer> res = new ArrayList<>();

        while (!deque.isEmpty()) {
            DepTreeNode node = deque.pop();
            if (node.left != null) {
                deque.add(new DepTreeNode(node.left, node.depth + 1));
            }
            if (node.right != null) {

                deque.add(new DepTreeNode(node.right, node.depth + 1));
            }
            if (curDepth != node.depth) {
                curDepth = node.depth;
                //深度深入，上一个访问节点的值就是 每一层的最右节点
                res.add(preVal);
            }

            preVal = node.val;
            if (deque.isEmpty()) {
                //补上漏掉的最后一个节点
                res.add(preVal);
            }
        }
        return res;
    }


    class DepTreeNode extends TreeNode {
        int depth;

        DepTreeNode(TreeNode node, int depth) {
            super(node.val);
            super.left = node.left;
            super.right = node.right;
            this.depth = depth;
        }
    }

    //dfs  每次优先访问右子节点
    public List<Integer> rightSideView1(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点我们才插入 此时是第一个这个深度 我们访问序列是先访问右
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }

    //bfs
    public List<Integer> rightSideView2(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.add(root);
        depthQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
                rightmostValueAtDepth.put(depth, node.val);

                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }


}
