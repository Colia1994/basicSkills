package org.kly.basicSkills.algorithm.toOffer;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @author colia
 * @date 2019/1/1 18:19
 */
public class 复杂链表的复制 {

    public RandomListNode Clone(RandomListNode pHead) {
        copyNext(pHead);
        copyRandom(pHead);
        return splitNext(pHead);
    }


    private void copyNext(RandomListNode pHead) {
        if (pHead == null) {
            return;
        }
        RandomListNode newNode = pHead.next;
        pHead.next = new RandomListNode(pHead.label);
        pHead.next.next = newNode;
        copyNext(newNode);
    }

    private void copyRandom(RandomListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return;
        }
        if (pHead.random != null) {
            pHead.next.random = pHead.random.next;
        }
        copyRandom(pHead.next.next);
    }

    private RandomListNode splitNext(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode copyNode = pHead.next;
        RandomListNode newNode = pHead;

        while (newNode.next != null) {
            RandomListNode node = newNode.next;
            newNode.next = newNode.next.next;

            newNode = node;
        }
        return copyNode;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
