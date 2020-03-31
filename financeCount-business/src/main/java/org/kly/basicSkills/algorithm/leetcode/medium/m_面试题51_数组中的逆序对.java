package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Colia
 * @Date 2020/3/31.
 */
public class m_面试题51_数组中的逆序对 {

    public int reversePairs(int[] nums) {
        //边界值判断
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] copy = new int[nums.length];
        return test(nums, copy, 0, nums.length - 1);
    }

    private int test(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            return 0;
        }

        //递归轮询，基于归并排序的思路
        int mid = (end + start) / 2;
        int left = test(array, copy, start, mid);
        int right = test(array, copy, mid + 1, end);

        //默认本次轮询完毕的左右数组都是有序的 start 到 start+length 内部有序  start+length+1到 end内部有序
        int i = mid;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= mid + 1) {
            //比较两个指针位置的大小，以此判断本轮递归中逆序对的数目
            if (array[i] > array[j]) {
                copy[indexCopy--] = array[i--];
                count += j - mid;
            } else {
                copy[indexCopy--] = array[j--];
            }
        }
        //补漏措施，防止while循环完毕 i和j的指针未归为
        while (i >= start) {
            copy[indexCopy--] = array[i--];
        }
        while (j >= mid + 1) {
            copy[indexCopy--] = array[j--];
        }
        //确保本次轮询结束start到end内部有序
        for (int s = start; s <= end; s++) {
            array[s] = copy[s];
        }

        return (left + right + count);
    }
}
