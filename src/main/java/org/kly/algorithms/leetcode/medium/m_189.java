package org.kly.algorithms.leetcode.medium;

public class m_189 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];

        for(int i=0;i<n;i++){
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }


    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5,6,7};
        m_189 obj = new m_189();
        obj.rotate(test, 3);
        for (int i : test) {System.out.print(i);}
    }
}
