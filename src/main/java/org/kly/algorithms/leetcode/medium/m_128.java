package org.kly.algorithms.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class m_128 {

    public int longestConsecutive(int[] nums) {

        Set<Integer> s1 = new HashSet<>();
        for (Integer i : nums) {
            s1.add(i);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            //这个判断是为了减少循环，不是最优起点（我这是最大值 则无需处理哦）
            if(!s1.contains(j+1)){
                int nMax = 1;
                while(s1.contains(j-1)){
                    nMax++;
                    j--;
                }
                max= Math.max(max,nMax);
            }
        }
        return max;
    }
}
