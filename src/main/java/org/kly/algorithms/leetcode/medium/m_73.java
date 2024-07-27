package org.kly.algorithms.leetcode.medium;

public class m_73 {

    public void setZeroes(int[][] matrix) {
        //第一行的0用来标记 每一列是否需要更新
        //第一列的0用来标记 每一行是否需要更新
        //第一行是否需要更新可以有第一列第一个决定 无需额外存储
        //确保每行扫描 第一个都是第一个处理 额外记录第一列是否存在0即可
        boolean flag = false;
        int x = matrix.length;
        int y = matrix[0].length;
        for(int i=0;i<x;i++){
            //先处理每一行的第一个 更新标记
            flag = flag || matrix[i][0] == 0;
            for(int j=1;j<y;j++){
                //正常更新
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        //重置为0，因为担心数据覆盖，从最后一行开始更新不会发生数据覆盖
        for(int i=x-1;i>=0;i--){

            for(int j=1;j<y;j++){
                //正常更新 行
                if(matrix[i][0] == 0 || matrix[0][j] ==0){
                    matrix[i][j]=0;
                }
            }
            if(flag){
                //标记 存在 则 当前行首需要更新为0
                matrix[i][0] = 0;
            }

        }

    }
}
