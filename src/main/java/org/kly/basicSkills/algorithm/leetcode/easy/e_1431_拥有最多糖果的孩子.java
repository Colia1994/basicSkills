package org.kly.basicSkills.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/6/1 11:04 上午
 */
public class e_1431_拥有最多糖果的孩子 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = candies[0];
        for (Integer i : candies) {
            if (i > max) {
                max = i;
            }
        }

        List<Boolean> result = new ArrayList<>();

        for (Integer i : candies) {
            result.add(i + extraCandies >= max );
        }

        return result;
    }
}
