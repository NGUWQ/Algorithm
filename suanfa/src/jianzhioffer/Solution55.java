package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/21
 * \* Time: 20:11
 */
/*
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class Solution55 {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fast=pHead;
        ListNode slow=pHead;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow)
                break;
        }
        if (fast==null||fast.next==null)
            return null;
        fast=pHead;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;

    }

    public static void main(String[] args) {

        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=node.next.next;

        System.out.println(new Solution55().EntryNodeOfLoop(node).val);
    }
}
