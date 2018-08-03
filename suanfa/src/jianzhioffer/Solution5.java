package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/26
 * \* Time: 20:46
 */
//输入一个链表，从尾到头打印链表每个节点的值。

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    //void display() {
        //System.out.print(val + " ");
    //}
}

class ListSort{
    private ListNode first;


    ListSort(){
        first=null;
    }

    /*测试
    public void method(){
        ListNode current=first;
        ArrayList<Integer> arrayList=printListFromTailToHead2(current);
        System.out.println(arrayList);
    }*/



    public void insert(int val){

        ListNode listNode=new ListNode(val);
        ListNode current=first;
        first=listNode;
        first.next=current;
    }

    public void displayList(){
        ListNode current=first;
        while (current!=null){
            //current.display();
            current=current.next;
        }
    }

}

public class Solution5 {
    ArrayList<Integer> list = new ArrayList<Integer>();

    //方法一：运用栈的性质
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    //方法二(递归思想)
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead2(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    public static void main(String[] args) {

        ListSort listSort=new ListSort();
        listSort.insert(33);
        listSort.insert(44);
        listSort.insert(55);
        listSort.insert(66);
        //listSort.displayList();
       //listSort.method();
    }
}