package org.kly.basicSkills.algorithm.leetcode.medium;

import java.util.*;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 * <p>
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/10
 */
public class m_752_打开转盘锁 {

    public static void main(String[] args) {
        m_752_打开转盘锁 m = new m_752_打开转盘锁();
        m.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
    }
    //bfs
    public int openLock(String[] deadends, String target) {
        Deque<String> deque = new LinkedList<>();
        deque.offer("0000");
        Set<String> visited = new HashSet<>();
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        visited.add("0000");

        int step = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();

            //同级扩散
            for (int i = 0; i < size; i++) {
                String now = deque.poll();
                //标记访问过
                if (dead.contains(now)) {
                    continue;
                }
                if (target.equals(now)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = sUp(now, j);
                    if (!visited.contains(up)) {
                        deque.offer(up);
                        visited.add(up);
                    }

                    String down = sDown(now, j);
                    if (!visited.contains(down)) {
                        deque.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }


    private String sUp(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '9') {
            ch[i] = '0';
        } else {
            ch[i] += 1;
        }
        return new String(ch);
    }

    private String sDown(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '0') {
            ch[i] = '9';
        } else {
            ch[i] -= 1;
        }
        return new String(ch);
    }

}
