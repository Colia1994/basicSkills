package org.kly.algorithms.leetcode.medium;

import java.util.List;

public class m_624 {

    public int maxDistance(List<List<Integer>> arrays) {
        int m = arrays.size();
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int count = 0;
        for(int i =1;i < m;i++){
            List<Integer> list = arrays.get(i);
            int nowLength = Math.max(list.get(list.size()-1) - min, max - list.get(0));
            count = Math.max(count,nowLength);


            min = Math.min(list.get(0),min);
            max = Math.max(list.get(list.size()-1),max);
        }
        return count;
    }
}
