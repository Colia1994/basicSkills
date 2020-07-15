package org.kly.algorithms.leetcode.medium;

/**
 * 给定一个从1 到 n 排序的整数列表。
 * 首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
 * 第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
 * 我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 返回长度为 n 的列表中，最后剩下的数字。
 * <p>
 * 示例：
 * <p>
 * 输入:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 * <p>
 * 输出:
 * 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/elimination-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author colia
 * @date 2018/12/9 23:25
 */
public class m_390_消除游戏 {

    /**
     * Brute Force
     * 我的答案 900ms时间
     */
    public int lastRemainingBruteForce(int n) {
        int step = 1;
        int left = 1;
        int right = n;
        boolean solution = true;//true means left
        while (left != right) {
            if (solution) {
                left += step;
                step = step * 2;
                int maxSpace = right;
                right = left;
                while (right + step <= maxSpace) {
                    right += step;
                }

            } else {
                right -= step;
                step = step * 2;
                int minSpace = left;
                left = right;
                while (left - step >= minSpace) {
                    left -= step;
                }
            }
            solution = !solution;
        }
        return left;
    }

    /**
     * Brute Force优化版 40ms
     */
    public int lastRemainingBruteBest(int n) {
        int step = 1;
        int left = 1;
        int right = n;
        boolean solution = true;//true means left
        while (left != right) {
            int dif = right - left;
            if (solution) {
                left += step;
                if (dif % (2 * step) == 0) {
                    right -= step;
                }

            } else {
                right -= step;
                if (dif % (2 * step) == 0) {
                    left += step;
                }
            }
            step = step * 2;

            solution = !solution;
        }
        return left;
    }

    /**
     * 答案
     */
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }
}
