package org.kly.algorithms.leetcode.medium;

public class m_80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int slow = 0, fast = 1;
        int count = 1;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[slow + 1] = nums[fast];
                slow++;
                count = 1;
            } else {
                if (count > 0) {
                    nums[slow + 1] = nums[fast];
                    slow++;
                    count--;
                }
            }
            fast++;
        }
        return slow + 1;
    }

//[0,0,1,1,2,3,2,3,3]
    //
}
