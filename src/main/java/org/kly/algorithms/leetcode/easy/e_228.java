package org.kly.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class e_228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0 ){
            return list;
        }
        if(nums.length == 1){
            list.add(nums[0] +"");
            return list;

        }
        int start = nums[0];
        int k = start;
        for(int i =1 ;i< nums.length; i++){
            if((nums[i] - i) == k){
                if(i == nums.length -1){
                    list.add(start + "->" + nums[i]);
                }
                continue;
            } else {

                String s = start+ "";
                if(start != nums[i-1]){
                    s= start + "->" + nums[i-1];
                }
                list.add(s);
                start = nums[i];
                k = start -i;
                if(i == nums.length -1){
                    list.add(start + "");
                }
            }
        }

        return list;

    }
}
