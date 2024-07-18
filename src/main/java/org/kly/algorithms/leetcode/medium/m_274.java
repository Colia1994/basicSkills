package org.kly.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * @author konglingyao
 * @date 2024/7/18
 */
public class m_274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if(citations[i] >= h){
                return h;
            } else{
                h--;
            }
        }

        return 0;
    }
}
