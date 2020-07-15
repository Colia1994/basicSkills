package org.kly.algorithms.leetcode.medium;

import org.kly.common.TreeNode;

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/5
 */
public class m_102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Integer> depRes = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        Deque<Integer> depStack = new LinkedList<>();
        deque.addFirst(root);
        depStack.addFirst(0);

        int curDep = 0;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            int nodeDep = depStack.pop();


            if (node.left != null) {
                deque.add(node.left);
                depStack.add(nodeDep + 1);
            }
            if (node.right != null) {
                deque.add(node.right);
                depStack.add(nodeDep + 1);
            }

            if(curDep != nodeDep){
                curDep = nodeDep;
                //表示该节点为新的一层的第一个节点
                res.add(new ArrayList<>(depRes));
                depRes.clear();
            }
            depRes.add(node.val);

            //漏掉最后一层
            if(deque.isEmpty()){
                res.add(new ArrayList<>(depRes));
            }
        }

        return res;
    }

    //lue
    public List<List<Integer>> levelOrder1(TreeNode root) {
        //当前层剩余数目
        int nextPrint = 1;
        //下一层的数目
        int newlevel = 0;
        TreeNode current;
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        if (root == null) {
            return listList;
        }
        //队列来实现广度优先搜索
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(root);
        while (!arrayDeque.isEmpty()) {
            current = arrayDeque.pop();
            if (current.left != null) {
                arrayDeque.addLast(current.left);
                newlevel++;
            }
            if (current.right != null) {
                arrayDeque.addLast(current.right);
                newlevel++;
            }
            integerList.add(current.val);
            nextPrint--;
            if (nextPrint == 0) {
                listList.add(integerList);
                integerList = new ArrayList<>();
                nextPrint = newlevel;
                newlevel = 0;
            }
        }
        return listList;
    }
}
