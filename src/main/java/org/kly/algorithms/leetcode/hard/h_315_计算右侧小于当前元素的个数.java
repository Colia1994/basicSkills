package org.kly.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/11
 */
public class h_315_计算右侧小于当前元素的个数 {

    //插入 二分
    public List<Integer> countSmaller1(int[] nums) {
        //逆序 插入排序 插入排序使用二分优化
        return null;
    }

    //归并
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        if(nums.length<=0){
            return res;
        }
        //原始数组的索引 每次移动 只移动索引
        int[] index = new int[nums.length];
        //辅助归并
        int[] copy = new int[nums.length];
        //搭配index数组计算每个index的置换次数 也是答案数组
        int[] count = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        guiBing(nums, copy, index, count, 0, nums.length - 1);
        for (int i = 0; i < count.length; i++) {
            res.add(i, count[i]);
        }
        return res;
    }

    private void guiBing(int[] nums, int[] copy, int[] index, int[] count, int s, int e) {
        if (s == e) {
            return;
        }
        int mid = (s + e) / 2;
        if (s < mid) {
            //left
            guiBing(nums, copy, index, count, s, mid);
        }
        if (mid + 1 < e) {
            //right
            guiBing(nums, copy, index, count, mid + 1, e);
        }

        //s - mid 有序 mid+1 - e有序 合并
        int i = mid, j = e, k = e;
        while (i >= s && j >= mid + 1) {
            if (nums[index[i]] <= nums[index[j]]) {
                copy[k--] = index[j--];
            } else {
                //i1是前面的一半 发生移动代表后续有比他小的
                count[index[i]] += k - i;
                copy[k--] = index[i--];
            }
        }
        while (i >= s) {
            copy[k--] = index[i--];
        }
        while (j >= mid + 1) {
            copy[k--] = index[j--];
        }
        System.arraycopy(copy, s, index, s, e - s + 1);

    }

    public static void main(String[] args) {
        h_315_计算右侧小于当前元素的个数 h = new h_315_计算右侧小于当前元素的个数();
        h.countSmaller(new int[]{-1,-1});

    }
    /**
     * nums copy index res
     * 5261 0000 0123  0000
     * 5261 2516 1032  1010
     * 5261 1256 0102  2110
     *
     */
}
