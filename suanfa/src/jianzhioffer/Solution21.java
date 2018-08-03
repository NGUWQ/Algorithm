package jianzhioffer;
import java.util.Iterator;
import java.util.Stack;
/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/31
 * \* Time: 19:35
 */
//定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
public class Solution21 {
    Stack<Integer> stack=new Stack<Integer>();

    public void push(int node) {
        stack.push(node);

    }

    public void pop() {
        stack.pop();

    }

    public int top() {
        int value=stack.peek();
        return value;

    }

    public int min() {
        if (stack.isEmpty())
            return -1;
        int key=stack.peek();
        int tmp=0;
        Iterator<Integer> iterator=stack.iterator();
        while (iterator.hasNext())
        {
            tmp=iterator.next();
            if (key>tmp){
                key=tmp;
            }
        }
        return key;
    }

    public static void main(String[] args) {

        Solution21 s=new Solution21();
        s.push(3);
        s.push(4);
        s.push(2);
        s.push(1);
        System.out.println(s.min());
    }
}
