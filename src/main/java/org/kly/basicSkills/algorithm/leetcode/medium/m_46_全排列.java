package org.kly.basicSkills.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/3
 */
public class m_46_全排列 {
    //LinkedList result = new LinkedList();
    //public void backtrack(路径，选择列表){
    //    if(满足结束条件){
    //        result.add(结果);
    //    }
    //    for(选择：选择列表){
    //        做出选择;
    //        backtrack(路径，选择列表);
    //        撤销选择;
    //    }
    //}
    //

    //回朔法
    public void backtrack(int[] nums,
                          List<List<Integer>> res,
                          LinkedList<Integer> trace,
                          boolean[] visited) {
        if (trace.size() == nums.length) {
            res.add(new ArrayList<>(trace));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            //选择
            trace.add(nums[i]);
            visited[i] = true;
            backtrack(nums, res, trace, visited);
            //撤销选择
            trace.removeLast();
            visited[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();


        backtrack(nums, res, new LinkedList<>(), new boolean[nums.length]);
        return res;
    }




}
