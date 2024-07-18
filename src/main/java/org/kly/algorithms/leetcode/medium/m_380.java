package org.kly.algorithms.leetcode.medium;

import java.util.*;

/**
 * @author konglingyao
 * @date 2024/7/18
 */
public class m_380 {

    public static class RandomizedSet {

        //存储下标
        HashMap<Integer, Integer> map;
        //存储真实值
        List<Integer> list;

        //设计随机化的set，保证插入移除都是o1时间复杂度，能去重复
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index =  map.get(val);
            //防止list自动修改下标，先用尾部和需要删除的位置交换
            int last = list.get(list.size() - 1);
            list.set(index, last);
            map.put(last, index);
            //删除尾部

            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            //值范围是全部int 包括负数
            Random rand = new Random();
            //0~total-1
            int rInt = rand.nextInt(list.size());
            return list.get(rInt);
        }
    }

}
