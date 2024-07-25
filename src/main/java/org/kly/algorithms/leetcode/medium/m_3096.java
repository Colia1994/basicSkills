package org.kly.algorithms.leetcode.medium;

/**
 * @author konglingyao
 * @date 2024/7/19
 */
public class m_3096 {

    public int minimumLevels(int[] possible) {
        int[] rightTotal = new int[possible.length];
        rightTotal[possible.length - 1] = possible[possible.length - 1] == 0 ? -1 : 1;
        for (int i = possible.length - 2; i >= 0; i--) {
            rightTotal[i] = rightTotal[i + 1] + (possible[i] == 0 ? -1 : 1);
        }
        rightTotal[0] = possible[0] == 0 ? -1 : 1;
        if (rightTotal[0] > rightTotal[1]) {
            return 1;
        }
        for (int i = 1; i < possible.length - 1; i++) {
            rightTotal[i] = rightTotal[i - 1] + (possible[i] == 0 ? -1 : 1);
            if (rightTotal[i] > rightTotal[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 0, 1, 0};
        //
        m_3096 m = new m_3096();
        m.minimumLevels(test);
    }


}
