package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * @Author konglingyao
 * @Date 2020/7/3
 */
public class m_208_实现Trie前缀树 {

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    class Trie {
        private boolean is_string = false;
        private Trie next[] = new Trie[26];

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie root = this;
            char[] w = word.toCharArray();
            for (char c : w) {
                if (root.next[c - 'a'] == null) {
                    root.next[c - 'a'] = new Trie();
                }
                root = root.next[c - 'a'];
            }
            root.is_string = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] w = word.toCharArray();
            Trie trie = this;
            for (char c : w) {
                if (trie.next[c - 'a'] == null) {
                    return false;
                }
                trie = trie.next[c - 'a'];
            }
            return trie.is_string;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] w = prefix.toCharArray();
            Trie trie = this;
            for (char c : w) {
                if (trie.next[c - 'a'] == null) {
                    return false;
                }
                trie = trie.next[c - 'a'];
            }
            return true;
        }
    }


}
