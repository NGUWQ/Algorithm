package jianzhioffer;

import java.util.LinkedList;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/11
 * \* Time: 0:18
 */
/*
* 输入两个链表，找出它们的第一个公共结点。*/
/*
* 思路:
* 创建一个列表,将链表1的值放进去,再每次迭代链表2的值.看链表1中是否包含公共节点.
* */
public class Solution37 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null)
            return null;
        LinkedList<ListNode> list=new LinkedList<ListNode>();
        ListNode temp=null;
        list.add(pHead1);
        while (pHead1!=null){
            pHead1=pHead1.next;
            list.add(pHead1);
        }
        while (pHead2!=null)
        {
            if (list.contains(pHead2)) {
                temp = pHead2;
                break;
            }
            pHead2=pHead2.next;
        }
        return temp;
    }

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while (p1!=p2){
            p1=(p1==null?pHead2:p1.next);
            p2=(p2==null?pHead1:p2.next);
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        ListNode node2=new ListNode(2);
        node.next=new ListNode(4);
//        node.next.next=new ListNode(4);
//        node2.next=node.next.next;
        System.out.println(new Solution37().FindFirstCommonNode2(node,node2));
    }
}
