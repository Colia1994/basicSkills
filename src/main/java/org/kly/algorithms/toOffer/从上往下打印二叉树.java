package org.kly.algorithms.toOffer;


import org.kly.infrastructure.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @author colia
 * @date 2018/12/31 0:24
 */
public class 从上往下打印二叉树 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }
        arrayDeque.addFirst(root);
        while (!arrayDeque.isEmpty()) {
            TreeNode newNode = arrayDeque.pop();
            arrayList.add(newNode.val);
            if (newNode.left != null) {
                arrayDeque.offerLast(newNode.left);
            }
            if (newNode.right != null) {
                arrayDeque.offerLast(newNode.right);
            }
        }

        return arrayList;
    }


}
