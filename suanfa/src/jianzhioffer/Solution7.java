package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/27
 * \* Time: 17:17
 */

//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
import java.util.Stack;

public class Solution7 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public  void push(int node) {
        stack1.push(node);

    }

    public  int pop() {
        if (stack1.isEmpty()&&stack2.isEmpty())
            throw new RuntimeException("queue is empty");
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();

    }

    public static void main(String[] args) {

        Solution7 s=new Solution7();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        for (int i=0;i<7;i++)
            System.out.println(s.pop());
    }
}