package org.kly;

import org.kly.leetcode.medium.SpiralMatrixII;
import org.kly.leetcode.medium.ZigZagConversion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        spiralMatrixII.generateMatrix(3);
        testInput();
    }

    private static void testInput(){
        int[] asd = new int[2];
        System.out.println(asd[0]);
    }
}
