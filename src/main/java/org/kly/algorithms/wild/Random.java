package org.kly.algorithms.wild;

/**
 * @Author konglingyao
 * @Date 2021/5/24
 */
public class Random {


    /**
     * 随机排列组合
     */
    public static String function(int length) {
        int[] randomArray = new int[length];
        int randomIndex, temp;
        for (int i = 0; i < length; i++) {
            randomArray[i] = i + 1;
        }
        //var randomArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = length - 1; i >= 0; i--) {
            randomIndex = (int) Math.floor(Math.random() * (i + 1));
            temp = randomArray[randomIndex];
            randomArray[randomIndex] = randomArray[i];
            randomArray[i] = temp;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            str.append(randomArray[i]);
        }
        return str.toString();
    }


    public static void main(String... args) {

        System.out.print(Random.function(9) + Random.function(9) + Random.function(5));

    }

}
