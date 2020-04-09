package org.kly.basicSkills.algorithm.toOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * @author colia
 * @date 2018/12/31 13:38
 */
public class 二叉搜索树的后序遍历序列 {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length < 1) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int start, int length) {

        int root = sequence[length - 1];
        int i = start;
        for (; i < start + length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        int j = i;
        for (; i < start + length - 1; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i > start) {
            left = VerifySquenceOfBST(sequence, start, i - start);
        }

        boolean right = true;
        if (i < length + start - 1) {
            right = VerifySquenceOfBST(sequence, i + 1, length + start - 1 - i);
        }
        return right && left;
    }
}

