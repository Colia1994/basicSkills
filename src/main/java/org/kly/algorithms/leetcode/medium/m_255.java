package org.kly.algorithms.leetcode.medium;

public class m_255 {

    /**
     * @param preorder [5,2,1,3,6]
     * @return false
     */
    public boolean verifyPreorder(int[] preorder) {
        //找到左子树和由=右子树，然后递归
        int start = 0;
        int end = preorder.length - 1;
        return verifyPreorder(preorder, start, end);
    }

    private boolean verifyPreorder(int[] preorder, int start, int end) {
        //找到左子树和由=右子树，然后递归

        if (start >= end) {
            return true;
        }

        //分割是 第一个i >0
        int mid = start;
        for (int i = start; i <= end; i++) {
            if (preorder[i] > preorder[start]) {
                mid = i;
                break;
            }
        }
        if(mid == start){
            mid = end+1;
        }

        //检查右子树是否存在比start还大大
        for (int i = mid + 1; i <= end; i++) {
            if (preorder[i] < preorder[start]) {
                return false;
            }
        }

        //左子树  右子树
        return verifyPreorder(preorder, start+1, mid - 1) && verifyPreorder(preorder, mid, end);
    }
}
