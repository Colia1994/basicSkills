package org.kly.algorithms.leetcode.hard;

import org.kly.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/6/16
 */
public class h_297_二叉树的序列化与反序列化 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> ser = new ArrayList<>();
        Deque<TreeNode> deq = new LinkedList<>();
        deq.add(root);
        while (deq.size() != 0) {
            TreeNode treeNode = deq.pop();
            if (null == treeNode) {
                ser.add("null");
            } else {
                ser.add(String.valueOf(treeNode.val));
                deq.offer(treeNode.left);
                deq.offer(treeNode.right);
            }

        }
        StringBuilder sb = new StringBuilder();
        for (String str : ser) {
            sb.append(str).append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ser = data.split(",");
        if(ser[0].equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(ser[0]));
        Deque<TreeNode> deq = new LinkedList<>();
        deq.offer(node);
        int curse = 1;
        while (curse < ser.length) {
            TreeNode treeNode = deq.pop();
            if (ser[curse].equals("null")) {
                treeNode.left = null;
            } else {
                treeNode.left = new TreeNode(Integer.parseInt(ser[curse]));
                deq.offer(treeNode.left);
            }
            if (ser[curse + 1].equals("null")) {
                treeNode.right = null;
            } else {
                treeNode.right = new TreeNode(Integer.parseInt(ser[curse + 1]));
                deq.offer(treeNode.right);

            }
            curse++;
            curse++;
        }
        return node;

    }


}
