package org.kly.basicSkills.algorithm.leetcode.hard;

import org.kly.common.TreeNode;

/**
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 * <p>
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * <p>
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 * <p>
 * 给出遍历输出 S，还原树并返回其根节点 root。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 *  
 * <p>
 * 提示：
 * <p>
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/6/18
 */
public class h_1028_从先序遍历还原二叉树 {

    public TreeNode recoverFromPreorder(String S) {
        String splitLine = "-";
        return diGui(S, splitLine);
    }

    private TreeNode diGui(String s, String splitLine) {
        TreeNode root = null;
        String regex = "(?<=[^@])@(?=[^@])".replace("@",splitLine);
        String[] trees = s.split(regex);


        if (trees.length >= 1) {
            root = new TreeNode(Integer.parseInt(trees[0]));
            if (trees.length == 1) {
                return root;
            }
        }
        splitLine += "-";
        if (trees.length >= 2) {
            root.left = diGui(trees[1], splitLine);
            if (trees.length == 2) {
                return root;
            }
        }
        if (trees.length >= 3) {
            root.right = diGui(trees[2], splitLine);

        }
        return root;
    }

    public static void main(String[] args){
        h_1028_从先序遍历还原二叉树 h = new h_1028_从先序遍历还原二叉树();
        TreeNode node = h.recoverFromPreorder("1-2--3--4-5--6--7");
        if(node==null){
            System.out.println("test01");
        }
    }
}
