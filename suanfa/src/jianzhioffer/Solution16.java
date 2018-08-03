package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/28
 * \* Time: 22:05
 */
//输入一个链表，反转链表后，输出链表的所有元素。
public class Solution16 {

    public ListNode ReverseList(ListNode head) {

        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;


    }
}
