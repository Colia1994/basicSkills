package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @Author Colia
 * @Date 2020/1/7 13:28
 */
public class m_148_排序链表 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //归并递归 空间超过预期 O logN  时间 n log n
    public static ListNode sortList(ListNode head) {
        if (head ==null || head.next == null) {
            return head;
        }
        ListNode quick = head.next;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode bef  = sortList(head);
        ListNode next = sortList(tmp);

        //合并数组
        return mergeTwoLists(bef, next);
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode resultNode = new ListNode(0);
        ListNode flowNode = resultNode;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                flowNode.next = l2;
                break;
            } else if (l2 == null) {
                flowNode.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                flowNode.next = l1;
                l1 = l1.next;
            } else {
                flowNode.next = l2;
                l2 = l2.next;
            }
            flowNode = flowNode.next;
        }
        return resultNode.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        l3.next =l4;
        l4.next = null;
        m_148_排序链表.sortList(l1);

    }

    //归并 非递归 空间符合预期 O logN  时间 n log n
    public static ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0, deep = 1;
        ListNode pre,l1,l2,res,h;
        ListNode quick = head;
        while (quick != null) {
            quick = quick.next;
            length++;
        }
        res = new ListNode(0);
        res.next = head;
        while (deep < length) {
            pre = res;
            h = res.next;
            while (h != null) {
                int count = deep;//计数器

                //本次需要合并的链表l1 l2
                l1 = h;

                while (count > 0 && h != null) {
                    h = h.next;
                    count--;
                }
                l2 = h;

                if(count >0){
                    break;
                }
                count = deep;//计数器

                while (count > 0 && h != null) {
                    h = h.next;
                    count--;
                }
                int c1 = deep, c2 = deep - count;
                while (c1 > 0 && c2 > 0) {
                    if (l1.val < l2.val) {
                        pre.next = l1;
                        l1 = l1.next;
                        c1--;
                    } else {
                        pre.next = l2;
                        l2 = l2.next;
                        c2--;
                    }
                    pre = pre.next;

                }

                pre.next = c1 > 0 ? l1 : l2;
                while(c1 >0 || c2 >0){
                    pre = pre.next;
                    c1--;
                    c2--;
                }
                pre.next = h;
            }
            //下次遍历宽度变宽
            deep = deep * 2;
        }
        return res.next;
    }
}
