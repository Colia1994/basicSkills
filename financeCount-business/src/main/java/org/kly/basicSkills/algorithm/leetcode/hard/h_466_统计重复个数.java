package org.kly.basicSkills.algorithm.leetcode.hard;

/**
 * 由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。
 * <p>
 * 如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。
 * <p>
 * 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。
 * <p>
 * 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * s1 ="acb",n1 = 4
 * s2 ="ab",n2 = 2
 * <p>
 * 返回：
 * 2
 *
 * @Author Colia
 * @Date 2020/4/19.
 */
public class h_466_统计重复个数 {

    // 循环节
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();
        // 特判
        if (len1 == 0 || len2 == 0 || n1 == 0 || n2 == 0) {
            return 0;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        // 记录下一个要匹配的s2中字符的索引
        int index = 0;
        // 记录匹配完的s2个数
        int count = 0;
        // 记录在遍历每个s1时匹配出的s2的个数，可能是包含了前面一个s1循环节的部分
        int[] countRecorder = new int[len2 + 1];
        // 记录在每个s1中想要匹配的s2中字符的索引
        int[] indexRecorder = new int[len2 + 1];

        for (int i = 0; i < n1; ++i) {
            // 遍历s1
            for (int j = 0; j < len1; ++j) {
                // 匹配s2字符，匹配成功，s2索引+1
                if (chars1[j] == chars2[index]) {
                    ++index;
                }
                // 匹配完一个s2，计数器+1，重置s2索引
                if (index == chars2.length) {
                    index = 0;
                    ++count;
                }
            }
            // 记录遍历完i个s1后s2出现的次数
            countRecorder[i] = count;
            // 记录遍历完第i个s1后s2下一个要被匹配到的字符下标
            indexRecorder[i] = index;
            // 剪枝
            // 查看该索引在之前是否已出现，出现即表示已经出现循环节，可以直接进行计算
            // 上一次出现该索引是在第j个s1中（同时可以说明第一个循环节的出现是从第j+1个s1开始的）
            for (int j = 0; j < i && indexRecorder[j] == index; ++j) {
                // preCount: 记录循环节出现之前的s2出现的个数
                int preCount = countRecorder[j];
                // patternCount: 记录所有循环节构成的字符串中出现s2的个数
                //      (n1 - 1 - j) / (i - j): 循环节个数
                //      countRecorder[i] - countRecorder[j]: 一个循环节中包含的s2个数
                int patternCount = ((n1 - 1 - j) / (i - j)) * (countRecorder[i] - countRecorder[j]);
                // remainCount: 记录剩余未构成完整循环节的部分出现的s2的个数
                //      通过取模从已有循环节记录中查找，并减去循环节之前出现的次数
                int remainCount = countRecorder[j + (n1 - 1 - j) % (i - j)] - countRecorder[j];
                // 三者相加，即为出现的s2的总次数
                return (preCount + patternCount + remainCount) / n2;
            }
        }
        // 没有循环节的出现，相当于直接使用暴力法
        return countRecorder[n1 - 1] / n2;
    }
}
