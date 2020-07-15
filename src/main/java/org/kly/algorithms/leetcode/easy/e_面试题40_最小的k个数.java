package org.kly.algorithms.leetcode.easy;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * @Author Colia
 * @Date 2020/3/20.
 */
public class e_面试题40_最小的k个数 {

    public int[] getLeastNumbers(int[] input, int k) {
        fastSort(input, 0, input.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = input[i];
        }
        return res;
    }

    private void fastSort(int[] a, int s, int e, int k) {
        if (s > e) return;
        int p = partation(a, s, e);
        if (p + 1 == k) {
            return;
        } else if (p + 1 < k) {
            fastSort(a, p + 1, e, k);
        } else {
            fastSort(a, s, p - 1, k);
        }
    }

    private int partation(int[] a, int s, int e) {
        int privot = a[e];//取最后一个数作为分区点
        int i = s;
        for (int j = s; j < e; j++) {
            if (a[j] < privot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, e);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
