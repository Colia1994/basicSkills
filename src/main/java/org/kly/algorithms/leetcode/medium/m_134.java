package org.kly.algorithms.leetcode.medium;

public class m_134 {

    /**
     * 假设从x开始走到y 走不到y=1
     * 则x-y之间肯定都不是起点，每个中间点的富裕油一定大于0 才只能走到y，起点默认邮箱是null必然不如x起点
     *
     * @param gas  油存储
     * @param cost 当前起点到x+1的路程
     * @return 起点油站
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startStation = 0;
        int nowStation = 0;
        int remindGas = 0;
//        int stations = 0;
        while (startStation < gas.length) {
            while (gas[nowStation] + remindGas >= cost[nowStation]) {
                //油支持继续走
                remindGas += gas[nowStation] - cost[nowStation];
                nowStation++;
//                stations++;
                nowStation = nowStation % gas.length;
                if (nowStation == startStation) {
                    //可走完
                    return startStation;
                }
            }
            //无法走完
            if (nowStation < startStation) {
                return -1;
            }
            startStation = nowStation + 1;
            nowStation = startStation;
            remindGas = 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        m_134 m = new m_134();
        System.out.println(m.canCompleteCircuit(gas, cost));
    }
}
