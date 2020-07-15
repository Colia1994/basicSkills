package org.kly.basicSkills.algorithm.leetcode.medium;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 *  
 * <p>
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/2
 */
public class m_378_有序矩阵中第K小的元素 {

    //借助优先队列 最小堆 实现
    public int kthSmallest1(int[][] matrix, int k) {
        //优先队列 设置最小堆
        PriorityQueue<Integer> MaxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] row : matrix) {
            for (int num : row) {
                //满k树木后 判断准备入列堆和列尾最大比较
                if (MaxPQ.size() == k && num > MaxPQ.peek())
                    break;
                MaxPQ.add(num);
                if (MaxPQ.size() > k)
                    MaxPQ.remove();
            }
        }
        //队列中k个元素 弹出第k个
        return MaxPQ.remove();
    }

    //二分查找
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }


}
