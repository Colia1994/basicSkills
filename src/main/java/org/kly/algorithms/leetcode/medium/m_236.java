package org.kly.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author konglingyao
 * @date 2024/7/16
 */
public class m_236 {

    /**
     * bfs * bfs 跑一遍 时间复杂度较高 为On2
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //bfs遍历 root 依次判断
        TreeNode n = root;
        do {
            if (verifyP(n.left, p) && verifyQ(n.left, q)) {
                n = n.left;
            } else if (verifyP(n.right, p) && verifyQ(n.right, q)) {
                n = n.right;
            } else {
                return n;
            }
        } while (n != null);
        return n;
    }

    public boolean verifyP(TreeNode n, TreeNode p) {
        if (n == null) {
            return false;
        }
        return n.val == p.val || verifyP(n.left, p) || verifyP(n.right, p);

    }

    public boolean verifyQ(TreeNode n, TreeNode q) {
        if (n == null) {
            return false;
        }
        return n.val == q.val || verifyQ(n.left, q) || verifyQ(n.right, q);
    }


    /**
     * bfs 遍历过程中记录每个节点的状态 减少遍历
     */
    public TreeNode lowestCommonAncestor_enhance(TreeNode root, TreeNode p, TreeNode q) {
        //bfs遍历 root 依次判断
        TreeNode n = root;
        Map<TreeNode, Boolean> pMap = new HashMap<>();
        Map<TreeNode, Boolean> qMap = new HashMap<>();
        do {
            if (verifyP_enhance(n.left, p, pMap) && verifyQ_enhance(n.left, q, qMap)) {
                n = n.left;
            } else if (verifyP_enhance(n.right, p, pMap) && verifyQ_enhance(n.right, q, qMap)) {
                n = n.right;
            } else {
                return n;
            }
        } while (n != null);
        return n;
    }

    public boolean verifyP_enhance(TreeNode n, TreeNode p, Map<TreeNode, Boolean> pMap) {
        if (n == null) {
            return false;
        }
        if (pMap.containsKey(n)) {
            return pMap.get(n);
        }
        boolean phas = n.val == p.val || verifyP_enhance(n.left, p, pMap) || verifyP_enhance(n.right, p, pMap);
        pMap.put(n, phas);

        return phas;

    }

    public boolean verifyQ_enhance(TreeNode n, TreeNode q, Map<TreeNode, Boolean> qMap) {
        if (n == null) {
            return false;
        }
        if (qMap.containsKey(n)) {
            return qMap.get(n);
        }
        boolean qhas = n.val == q.val || verifyQ_enhance(n.left, q, qMap) || verifyQ_enhance(n.right, q, qMap);
        qMap.put(n, qhas);
        return qhas;

    }


    /**
     * 简单化思路，pq一定在树里，尝试bfs一次递归，当n的left包含p，q right也包含p，q，则n一定时最优
     * 如果left包含 则返回left 如果 right包含 则返回right
     */
    public TreeNode lowestCommonAncestor_bfs_On(TreeNode root, TreeNode p, TreeNode q) {
        //跳出条件
        if (root == null || root == p || root == q) {
            return root;
        }
        //bfs遍历 root 依次判断
        TreeNode left = lowestCommonAncestor_bfs_On(root.left, p, q);
        TreeNode right = lowestCommonAncestor_bfs_On(root.right, p, q);
        if (left == null && right != null) {
            return right;
        }
        if (right == null && left != null) {
            return left;
        }
        //都为空 实际不可能， p q一定存在于树中
        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


