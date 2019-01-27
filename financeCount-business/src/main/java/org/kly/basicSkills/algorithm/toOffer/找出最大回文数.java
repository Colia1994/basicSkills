package org.kly.basicSkills.algorithm.toOffer;

/**
 * @author colia
 * @date 2019/1/24 19:16
 */
public class 找出最大回文数 {

    public static void main(String[] args) {
        找出最大回文数 test = new 找出最大回文数();
        int[] a = new int[]{122,121,232,1,3,5};
        System.out.println(test.rollNumber(a));
    }

    private int rollNumber(int[] numbers) {
        int rollNumber = -1;
        for (int number : numbers) {
            if (isRollNumber(number) && rollNumber < number) {
                rollNumber = number;
            }
        }
        return rollNumber;
    }

    private boolean isRollNumber(int number) {
        if (number < 0)
            return false;
        int sum = 0;
        int origin = number;
        while (number > 0) {
            int num = number % 10;
            sum = sum * 10 + num;
            number /= 10;
        }
        return sum == origin;
    }
}
