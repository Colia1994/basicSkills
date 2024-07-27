package org.kly.algorithms.leetcode.easy;

/**
 * @author konglingyao
 * @date 2024/7/26
 */
public class e_1189 {

    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[5];
        for (char c : text.toCharArray()) {
            if (c == 'b') {
                cnt[0]++;
            } else if (c == 'a') {
                cnt[1]++;
            } else if (c == 'l') {
                cnt[2]++;
            } else if (c == 'o') {
                cnt[3]++;
            } else if (c == 'n') {
                cnt[4]++;
            }
        }
        cnt[2] /= 2;
        cnt[3] /= 2;
        int ans = Integer.MAX_VALUE;
        for (int x : cnt) {
            ans = Math.min(ans, x);
        }
        return ans;
    }
}
