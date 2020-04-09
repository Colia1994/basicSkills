package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Colia
 * @Date 2020/3/31.
 */
public class m_912_排序数组 {

    //快排
    public int[] sortArrayKP(int[] nums) {
        quickSort(0, nums.length - 1, nums);
        return nums;
    }

    private void quickSort(int start, int end, int[] nums) {
        if (start >= end) {
            return;
        }
        int p = partition(start, end, nums);
        quickSort(start, p - 1, nums);
        quickSort(p + 1, end, nums);
    }

    private int partition(int start, int end, int[] nums) {
        int s = start, e = end - 1;

        while (s <= e) {
            if (nums[s] > nums[end]) {
                swap(nums, s, e);
                e--;
            } else {
                s++;
            }
        }
        e++;
        swap(nums, e, end);
        return e;
    }

    private void swap(int[] nums, int b, int a) {
        int x = nums[b];
        nums[b] = nums[a];
        nums[a] = x;
    }


    //冒泡
    public int[] sortArrayMP(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                return nums;
            }

        }
        return nums;
    }


    //插入
    public int[] sortArrayCR(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {     // 将当前元素移动到合适的位置
                swap(nums, j, j - 1);
                j--;
            }
        }
        return nums;
    }

    //选择
    public int[] sortArrayXZ(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int maxIndex = 0;         // 最大元素的位置
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[maxIndex] < nums[j]) {
                    maxIndex = j;
                }
            }
            swap(nums, maxIndex, nums.length - i - 1);
        }
        return nums;
    }

    //基尔
    private int[] shellSor2(int[] nums) {
        int gap = nums.length >> 1;
        while (gap > 0) {
            for (int i = 0; i < gap; i++) {                        // 对每个子序列进行排序
                for (int j = i + gap; j < nums.length; j += gap) {     // 插入排序的部分
                    int temp = j;
                    while (temp > i && nums[temp] < nums[temp - gap]) {
                        swap(nums, temp, temp - gap);
                        temp -= gap;
                    }
                }
            }
            gap >>= 1;
        }
        return nums;
    }


    //二叉搜索树排序
    private int[] bstSort(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);   // 构建根节点
        for (int i = 1; i < nums.length; i++) {  // 将所有的元素插入到二叉搜索树中
            buildTree(root, nums[i]);
        }
        inorderTraversal(root, nums, new int[1]);// 中序遍历获取二叉树中的所有节点
        return nums;
    }

    private void inorderTraversal(TreeNode node, int[] nums, int[] pos) {
        if (node == null) return;
        inorderTraversal(node.left, nums, pos);
        nums[pos[0]++] = node.val;
        inorderTraversal(node.right, nums, pos);
    }

    private void buildTree(TreeNode node, int num) {
        if (node == null) return;
        if (num >= node.val) {                   // 插入到右子树中
            if (node.right == null) {
                node.right = new TreeNode(num);
            } else {
                buildTree(node.right, num);
            }
        } else {                                 // 插入到左子树中
            if (node.left == null) {
                node.left = new TreeNode(num);
            } else {
                buildTree(node.left, num);
            }
        }
    }

    static class TreeNode {   // 树节点的数据结构
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
