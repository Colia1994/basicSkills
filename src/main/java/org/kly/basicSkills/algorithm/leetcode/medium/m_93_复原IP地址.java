package org.kly.basicSkills.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/5
 */
public class m_93_复原IP地址 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        LinkedList<String> ipCodes = new LinkedList<>();
        backtrack(res, ipCodes, 0, s);
        return res;
    }

    private void backtrack(List<String> res, LinkedList<String> ipCodes, int i, String s) {
        if (ipCodes.size() == 4 && i == s.length()) {
            //满足条件输出
            res.add(String.join(".", ipCodes));
        }
        for (int j = i; j < s.length() && j < i + 3; j++) {
            String b = s.substring(i, j + 1);
            //剪枝
            if (Integer.parseInt(b) > 255
                    || ipCodes.size() > 3
                    || (b.charAt(0) == '0' && b.length() != 1)) {
                break;
            }
            //选择
            ipCodes.addLast(b);
            backtrack(res, ipCodes, j + 1, s);
            //撤销选择
            ipCodes.removeLast();
        }

    }


    int n;
    String s;
    LinkedList<String> segments = new LinkedList<String>();
    ArrayList<String> output = new ArrayList<String>();

    public boolean valid(String segment) {
    /*
    Check if the current segment is valid :
    1. less or equal to 255
    2. the first character could be '0'
    only if the segment is equal to '0'
    */
        int m = segment.length();
        if (m > 3)
            return false;
        return (segment.charAt(0) != '0') ? (Integer.parseInt(segment) <= 255) : (m == 1);
    }

    public void update_output(int curr_pos) {
    /*
    Append the current list of segments
    to the list of solutions
    */
        String segment = s.substring(curr_pos + 1, n);
        if (valid(segment)) {
            segments.add(segment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    public void backtrack(int prev_pos, int dots) {
    /*
    prev_pos : the position of the previously placed dot
    dots : number of dots to place
    */
        // The current dot curr_pos could be placed
        // in a range from prev_pos + 1 to prev_pos + 4.
        // The dot couldn't be placed
        // after the last character in the string.
        int max_pos = Math.min(n - 1, prev_pos + 4);
        for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {
            String segment = s.substring(prev_pos + 1, curr_pos + 1);
            if (valid(segment)) {
                segments.add(segment);  // place dot
                if (dots - 1 == 0)      // if all 3 dots are placed
                    update_output(curr_pos);  // add the solution to output
                else
                    backtrack(curr_pos, dots - 1);  // continue to place dots
                segments.removeLast();  // remove the last placed dot
            }
        }
    }

    public List<String> restoreIpAddresses2(String s) {
        n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return output;
    }
}
