package org.kly.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class e_1056 {

    Map<Integer,Integer> map = new HashMap<>();
    {
        map.put(0,0);
        map.put(6,9);
        map.put(9,6);
        map.put(1,1);
        map.put(8,8);
    }
    public boolean confusingNumber(int n) {
        int org = n;
        int num = 0;
        while(n>0){
            int y = n%10;
            if(map.get(y)!= null){
                num = num * 10 + map.get(y);
            } else {
                return false;
            }
            n = n/10;
        }
        return num != org;
    }

    public static void main(String[] args) {
        e_1056 o = new e_1056();
        System.out.println(o.confusingNumber(19));
    }
}
