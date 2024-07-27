package org.kly.algorithms.leetcode.medium;

import java.util.Arrays;

public class m_280 {

    public void wiggleSort(int[] nums) {
        int[] org = new int[nums.length];
        System.arraycopy(nums, 0, org, 0, nums.length);

        Arrays.sort(org);
        int x = 1,y= nums.length-1;
        int l=0;
        nums[0] = org[0];
        while(x<=y){
            if(x<y){
                nums[++l] = org[y];
                nums[++l] = org[x];
                x++;
                y--;
            }
            if(x==y){
                nums[++l] = org[x];
                break;
            }
        }



    }
}
