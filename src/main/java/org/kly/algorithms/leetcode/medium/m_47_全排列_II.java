package org.kly.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 * @Author konglingyao
 * @Date 2020/7/3
 */
public class m_47_全排列_II {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums.length == 0) {
            return result;
        }
        //首先给数组排序
        Arrays.sort(nums);
        findUnique(nums, new boolean[nums.length], new LinkedList<>(), result);
        return result;
    }

    public void findUnique(int[] nums, boolean[] visited, LinkedList<Integer> trace, List<List<Integer>> result) {
        //结束条件
        if (trace.size() == nums.length) {
            result.add(new ArrayList<>(trace));
        }
        //选择列表
        for (int i = 0; i < nums.length; i++) {
            //其次，我们已经选择过的不需要再放进去了
            if (visited[i]) {
                continue;
            }
            //接下来，如果当前节点与他的前一个节点一样，并其他的前一个节点已经被遍历过了，那我们也就不需要了。
            //判断i-1位置是否和当前位置一样 且刚被撤销过，被撤销过才是!visited[i - 1]
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            //做出选择
            trace.add(nums[i]);
            visited[i] = true;
            findUnique(nums, visited, trace, result);
            //撤销选择
            trace.removeLast();
            visited[i] = false;
        }
    }


    public static void main(String[] args) {
        m_47_全排列_II solution = new m_47_全排列_II();
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = solution.permuteUnique(nums);
        System.out.println(res);
    }


}
