package jianzhioffer;

import java.util.Stack;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/31
 * \* Time: 22:03
 */
/*
* 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
* 假设压入栈的所有数字均不相等。
* 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
* 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
* （注意：这两个序列的长度是相等的）*/
public class Solution22 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {

        if (pushA==null||popA==null||popA.length==0||pushA.length==0||pushA.length!=popA.length)
            return false;
        Stack<Integer> stack=new Stack<Integer>();
        int i=0;
        int j=0;
        stack.push(pushA[i++]);
        while (j<=popA.length-1){
            while (popA[j]!=stack.peek()){
                if (i==pushA.length)
                    return false;
                stack.push(pushA[i++]);
            }
            j++;
            stack.pop();
        }
        return true;
    }


    /*思路:
    利用一个辅助栈,压入所要进栈的数组,定义一个下标,如pop数组最先出栈是4,
    即一直压栈相等的话就出栈,否则就一直压栈。
    如此下去,如果栈为空就说明两个序列匹配,否则就不匹配.
    * */
    public boolean IsPopOrder2(int [] pushA,int [] popA) {

        if (popA.length==0||pushA.length==0)
            return false;
        Stack<Integer> stack=new Stack<Integer>();
        int index=0;
        for (int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty()&&stack.peek()==popA[index])
            {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution22 s=new Solution22();

        int [] a={1,2,3,4,5};
        int [] b={5,4,3,2,1};
        System.out.println(s.IsPopOrder2(a,b));
    }
}
