package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/28
 * \* Time: 20:25
 */
//输入一个链表，输出该链表中倒数第k个结点。
public class Solution15 {

    public ListNode FindKthToTail(ListNode head, int k) {

        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return i < k ? null : q;
    }
}
