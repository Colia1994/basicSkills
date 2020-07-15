package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 * 说明: 假设矩形面积不会超出 int 的范围。
 *
 * @Author konglingyao
 * @Date 2020/7/7
 */
public class m_223_矩形面积 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int m1 = Math.abs(C - A) * Math.abs(D - B);
        int m2 = Math.abs(G - E) * Math.abs(H - F);
        //
        if (E >= C || G <= A || F >= D || H <= B) {
            return m1 + m2;
        }

        int i1, i2, j1, j2;

        //相交后面积
        i1 = Math.max(E, A);
        i2 = Math.min(G, C);
        j1 = Math.max(F, B);
        j2 = Math.min(H, D);

        return m1 + m2 - (i2 - i1) * (j2 - j1);
    }

    public int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {

        int overArea = 0;
        if (Math.min(C, G) > Math.max(A, E) && Math.min(D, H) > Math.max(B, F)) {
            //x轴（有可能是负数）：Math.min(C,G) - Math.max(A,E)
            //y轴（有可能是负数）：Math.min(D,H) - Math.max(B,F)
            //最后结果取绝对值
            overArea = Math.abs((Math.min(C, G) - Math.max(A, E)) *
                    (Math.min(D, H) - Math.max(B, F)));
        }
        //第一个矩阵面积
        int firstRecArea = Math.abs((C - A) * (D - B));

        //第二个矩阵面积
        int secondRecArea = Math.abs((G - E) * (H - F));

        //最终的面积=第一个矩阵面积+第二个矩阵面积-重叠面积
        return firstRecArea + secondRecArea - overArea;

    }
}
