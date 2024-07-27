package org.kly.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class e_760 {

    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            Queue<Integer> queue =  map.get(nums2[i]);
            if(queue == null){
                queue = new LinkedList<>();
            }
            queue.add(i);
            map.put(nums2[i],queue);
        }

        int[] mapping = new int[nums1.length];

        for(int i =0;i<nums1.length;i++){
            Queue<Integer> queue =  map.get(nums1[i]);
            mapping[i] = queue.poll();
        }

        return mapping;

    }
}
