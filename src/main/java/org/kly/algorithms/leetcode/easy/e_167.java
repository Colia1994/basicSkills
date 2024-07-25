package org.kly.algorithms.leetcode.easy;

public class e_167 {


    public int[] twoSum(int[] numbers, int target) {
        int x =0,y=numbers.length-1;

        while(x<y){
            if(numbers[x]+numbers[y]<target){
                x++;
            } else if(numbers[x]+numbers[y]>target){
                y--;
            } else {
                return new int[]{x+1,y+1};
            }
        }
        return numbers;
    }
}
