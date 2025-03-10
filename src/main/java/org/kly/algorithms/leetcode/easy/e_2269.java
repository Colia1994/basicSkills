package org.kly.algorithms.leetcode.easy;

/**
 * @author konglingyao
 * @date 2025/3/10
 */
public class e_2269 {

    public int divisorSubstrings(int num, int k) {


        String numStr = Integer.toString(num);

        int i = 0, j = i + k;

        if (k > numStr.length()) {
            return 0;
        }
        int count =0;
        for (; j <= numStr.length(); i++, j++) {
           int buty = Integer.valueOf(numStr.substring(i,j));
           if(buty == 0){
               continue;
           }
           if(num % buty == 0){
               count++;
           }
        }
        return count;
    }
}
