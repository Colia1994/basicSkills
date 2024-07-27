package org.kly.algorithms.leetcode.medium;

public class m_1060 {

    public int missingElement(int[] nums, int k) {
        int dis = nums[0] - 0;
        int n = nums.length;
        int maxdis = nums[n - 1] - dis - n + 1;
        if (k <= maxdis) {
            // 二分查找
            int start = 0;
            int end = n - 1;
            while (start < end) {
                int mid = start+  (end - start) / 2;
                if ((nums[mid] - dis - mid) < k) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            int dis2 = nums[start - 1] - (start -1) - dis;
            int step = k - dis2;
            return nums[start - 1] + step;
        }
        // 此时 k在数组外 直接返回即可
        return nums[n - 1] + k - maxdis;

    }
}
