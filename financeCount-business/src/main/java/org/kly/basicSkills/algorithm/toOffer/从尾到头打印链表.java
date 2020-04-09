package org.kly.basicSkills.algorithm.toOffer;


import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * @author colia
 * @date 2018/12/30 17:47
 */
public class 从尾到头打印链表 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {


        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null) {
            return arrayList;
        }
        printNode(listNode, arrayList);
        return arrayList;
    }

    private void printNode(ListNode listNode, ArrayList<Integer> arrayList) {

        if (listNode.next != null) {
            printNode(listNode.next, arrayList);
        }
        arrayList.add(listNode.val);
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
