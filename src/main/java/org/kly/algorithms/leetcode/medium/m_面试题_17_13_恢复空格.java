package org.kly.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。
 * 像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。
 * 在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。
 * 假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * 示例：
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/re-space-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/9
 */
public class m_面试题_17_13_恢复空格 {


    public int respace(String[] dictionary, String sentence) {
        //构建字典树
        Trie root = new Trie();
        for (String str : dictionary) {
            root.insert(str);
        }
        //dp
        int[] dp = new int[sentence.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            Trie node = root;
            for (int j = i; j >= 1; j--) {
                //判断向前的这串字符在字典树中是否存在
                int t = sentence.charAt(j - 1) - 'a';

                if (node.next[t] == null) {
                    break;
                } else {
                    if (node.next[t].isString) {
                        dp[i] = Math.min(dp[i], dp[j - 1]);
                    }
                }
                //如果遍历到一半发现已经没有不存在字符了 直接返回 节省时间
                node = node.next[t];

            }
        }
        return dp[sentence.length()];
    }

    public static void main(String[] args) {
        m_面试题_17_13_恢复空格 m = new m_面试题_17_13_恢复空格();
        m.respace(new String[]{"looked", "just", "like", "her", "brother"}, "jesslookedjustliketimherbrother");

    }

    class Trie {
        Trie[] next;
        boolean isString;

        Trie() {
            this.next = new Trie[26];
            this.isString = false;
        }

        void insert(String str) {
            Trie root = this;
            for (int i = str.length() - 1; i >= 0; i--) {
                if (root.next[str.charAt(i) - 'a'] == null) {
                    root.next[str.charAt(i) - 'a'] = new Trie();

                }
                root = root.next[str.charAt(i) - 'a'];
                if (i == 0) {
                    root.isString = true;
                }

            }
        }
    }

    public int respace1(String[] dictionary, String sentence) {
        int n = sentence.length();

        Trie1 root = new Trie1();
        for (String word : dictionary) {
            root.insert(word);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie1 curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.next[t];
            }
        }
        return dp[n];
    }


    class Trie1 {
        public Trie1[] next;
        public boolean isEnd;

        public Trie1() {
            next = new Trie1[26];
            isEnd = false;
        }

        public void insert(String s) {
            Trie1 curPos = this;

            for (int i = s.length() - 1; i >= 0; --i) {
                int t = s.charAt(i) - 'a';
                if (curPos.next[t] == null) {
                    curPos.next[t] = new Trie1();
                }
                curPos = curPos.next[t];
            }
            curPos.isEnd = true;
        }
    }


}
