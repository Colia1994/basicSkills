package org.kly.algorithms.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class m_71 {

    /**
     * path = "/a/./b/../../c/"
     * <p>
     * stack =
     * "/c"
     */
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String[] split = path.split("/");
        for (String s : split) {
            //如果是.. 则 优化 队列 对尾
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (s.length() == 0 || s.equals(".")) {
                //如果是. 直接跳过 如果是空格 意味着// 也跳过

            } else {
                stack.offerLast(s);
            }
        }

        //构造最终
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("/");
        } else {
            while (!stack.isEmpty()) {
                sb.append("/");
                sb.append(stack.pollFirst());
            }
        }

        return sb.toString();

    }
}
