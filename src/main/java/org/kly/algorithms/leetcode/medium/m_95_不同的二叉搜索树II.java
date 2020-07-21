package org.kly.algorithms.leetcode.medium;

import org.kly.infrastructure.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：3
 * 输出：
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @Author konglingyao
 * @Date 2020/7/21
 */
public class m_95_不同的二叉搜索树II {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTree(1, n);

    }

    private List<TreeNode> generateTree(int s, int e) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (s > e) {
            allTrees.add(null);
            return allTrees;
        }
        //每个节点作为根节点
        for (int i = s; i <= e; i++) {
            //从s-i 组成一个子树
            List<TreeNode> leftNodes = generateTree(s, i - 1);

            //从i-e 组成一个子树
            List<TreeNode> rightNodes = generateTree(i + 1, e);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }


        }
        return allTrees;

    }

}
