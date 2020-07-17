package org.kly.infrastructure.common;

/**
 * @Author Colia
 * @Date 2020/3/18.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;


    public String data;
    public boolean isVisited = false;

    public TreeNode(int x) {

        val = x;
    }


    public TreeNode(int key, String data) {
        this.val = key;
        this.data = data;
        this.left = null;
        this.right = null;
    }

}
