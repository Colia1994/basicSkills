package org.kly.basicSkills.algorithm.wild;

/**
 * 假设存在长度为n 里面分布折1-n的正整数的数组 N[]，乱序，不重复
 * 存在一个该数组的子集M[]
 * 打印输出N数组中不存在于M数组的内容
 *
 * @Author konglingyao
 * @Date 2020/6/2 11:20 上午
 */
public class 非子集的数组内容 {

    public void notInCollection(int[] N, int[] M) {
        for (int i : M) {
            //以此为起点 让数组N中的数子和下标对应
            int change = i;
            while (N[change - 1] != change) {
                int vot = N[change - 1];
                N[change - 1] = change;
                change = vot;
            }
            N[i - 1] = -1;
        }
        for (int j : N) {
            if (j != -1) {
                System.out.println(j);
            }
        }
    }


    public static void main(String[] args) {
        int[] N = new int[]{1, 3, 2, 6, 7,5, 4, 9, 8};
        int[] M = new int[]{5,2, 1};
        非子集的数组内容 kol = new 非子集的数组内容();
        kol.notInCollection(N, M);

    }


}
