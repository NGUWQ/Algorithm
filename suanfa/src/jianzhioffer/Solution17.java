package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/29
 * \* Time: 14:13
 */

/*输入两个单调递增的链表，输出两个链表合成后的链表，
当然我们需要合成后的链表满足单调不减规则。*/

//利用递归思想,当连个链表不为空的时候,
// 比较两个链表的头节点,从而不断递归调用自身比较
public class Solution17 {

    public ListNode Merge(ListNode list1,ListNode list2) {

        ListNode head;
        if (list1==null)
            return list2;
        if (list2==null)
            return list1;
        if(list1.val<list2.val){
            head=list1;
            head.next=Merge(list1.next,list2);
        }
        else {
            head=list2;
            head.next=Merge(list2.next,list1);
        }
        return head;
    }
}
