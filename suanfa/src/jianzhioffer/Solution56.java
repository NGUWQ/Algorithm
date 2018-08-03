package jianzhioffer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/21
 * \* Time: 21:34
 */
/*
* 在一个排序的链表中，存在重复的结点，
* 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
* */
public class Solution56 {

    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null||pHead.next==null)
            return pHead;

        int firstNumber=pHead.val;
        int myFirst=-1;
        if (firstNumber==myFirst)
            myFirst=-2;
        ListNode head=new ListNode(myFirst);
        head.next=pHead;
        ListNode p=head;
        ListNode q=head.next;
        while (q!=null){

            while (q.next!=null&&q.val==q.next.val)
                q=q.next;
            if (p.next!=q){
                q=q.next;
                p.next=q;
            }
            else {
                p=q;
                q=q.next;
            }
        }
        return p;
    }

    //递归
    public ListNode deleteDuplication2(ListNode pHead){
        if (pHead==null||pHead.next==null)
            return pHead;
        ListNode current=null;
        if (pHead.val==pHead.next.val){
            current=pHead.next.next;
            while (current!=null&&current.val==pHead.val){
                current=current.next;
            }
            return deleteDuplication2(current);
        }
        else{
            current=pHead.next;
            pHead.next=deleteDuplication2(current);
            return pHead;
        }
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(-10);
        node.next=new ListNode(-1);
        node.next.next=new ListNode(-1);
        node.next.next.next=new ListNode(5);
        node.next.next.next.next=new ListNode(7);


        System.out.println(new Solution56().deleteDuplication2(node).next.val);
    }
}
