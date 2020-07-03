package org.kly.basicSkills.algorithm.leetcode.easy;

import org.kly.common.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/3
 */
public class e_108_将有序数组转换为二叉搜索树 {
    //中间为偏前的为根节点 递归实现
    public TreeNode sortedArrayToBST(int[] nums) {
        return z(nums,0,nums.length-1);
    }

    private TreeNode z(int[] nums, int start, int end) {
        if(start > end){
            return null;
        }
        if(start == end){
            return new TreeNode(nums[start]);
        }
        int z = (end + start) / 2;
        TreeNode node = new TreeNode(nums[z]);
        node.left = z(nums, start, z - 1);
        node.right = z(nums, z + 1, end);
        return node;
    }
}
