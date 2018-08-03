package shujujiegou.day4;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/13
 * \* Time: 17:15
 */
public class yuesefu
{
    static class Node
    {
        int val;
        Node next;
        Node(int v)
        {
            val=v;
        }
    }
    public static void main(String[] args) {
        int N=20;//表示总个数
        int M=7;//数到几出列

        //头节点单列出来，方便形成循环链表
        Node t=new Node(1);
        Node x=t;
        //建立单向链表
        for(int i=2;i<=N;i++)
        {
            x=(x.next=new Node(i));
        }

        //最后一个节点的next指向第一个节点，形成循环链表
        x.next=t;
        System.out.println("依次出来的顺序为：");
        while(x!=x.next)
        {
            for(int i=1;i<M;i++)
            {
                x=x.next;
            }
            System.out.print(x.next.val+" ");
            x.next=x.next.next;
        }
        System.out.println();
        System.out.println("最后剩余的是： "+x.val);
    }
}