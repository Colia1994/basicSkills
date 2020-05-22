package org.kly.basicSkills.algorithm.leetcode.medium;

import org.kly.common.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/5/22 10:21 上午
 */
public class m_105_从前序与中序遍历序列构造二叉树 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int l1 = preorder.length;
        int l2 = inorder.length;
        if(l1 == 0 || l2 == 0){
            return null;
        }

        return build(preorder, inorder, 0, 0, l2 - 1);

    }

    private static TreeNode build(int[] preorder, int[] inorder, int i1, int j1, int j2) {
        TreeNode node = new TreeNode(preorder[i1]);
        int leftLength = 0;
        int rightLength;
        for (int j = j1; j <= j2; j++) {
            if (inorder[j] == preorder[i1]) {
                leftLength = j - j1;
                break;
            }
        }
        rightLength = j2 - j1 - leftLength;

        if (leftLength != 0) {
            node.left = build(preorder, inorder, i1 + 1, j1, j1 + leftLength - 1);

        }
        if (rightLength != 0) {
            node.right = build(preorder, inorder, i1 + 1 + leftLength, j1 + leftLength + 1, j2);
        }
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode result = m_105_从前序与中序遍历序列构造二叉树.buildTree(preorder, inorder);
        System.out.println(result);
    }
}
