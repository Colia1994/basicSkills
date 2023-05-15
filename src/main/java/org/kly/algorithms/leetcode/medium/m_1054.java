package org.kly.algorithms.leetcode.medium;

public class m_1054 {

    public int[] rearrangeBarcodes(int[] barcodes) {
        //找出每个code的频率
        int[] countNumArr = new int[10001];
        int mx = 0;
        int max = 0;
        for (int i : barcodes) {
            ++countNumArr[i];
            if (mx == Math.max(mx, countNumArr[i])) {

            } else {
                mx = Math.max(mx, countNumArr[i]);
                max = i;
            }
        }

        int[] res = new int[barcodes.length];
        int start = 0;
        int now = 0;
        for (int v = start; countNumArr[max] > 0; v += 2) {
            res[v] = max;
            now = v + 2;
            countNumArr[max]--;
            if (now >= res.length) {
                v = start++;
                now = start++;
            }
        }

        for (int i = 0; i < countNumArr.length; i++) {
            for (int v = now; countNumArr[i] > 0; v += 2) {
                if (v >= res.length) {
                    v = ++start;
                }
                res[v] = i;
                countNumArr[i]--;
                now = v + 2;
            }
        }

        return res;
    }
}
