package shujujiegou.day3;

import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/5
 * \* Time: 14:43
 */
//一个简单的栈
class StackX{

    private int maxSize;
    private long[] a;
    private int top;

    public StackX(int s) {
        maxSize=s;
        a=new long[maxSize];
        top=-1;//栈为空时
    }

    public void push(long value)//push方法，每次调用之后会有一个新的元素在栈顶
    {
        a[++top]=value;
    }

    public long pop()//pop方法，每次移出一个元素
    {
        return a[top--];
    }

    public long peek()//查看当前位置的元素
    {
        return a[top];
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public boolean isFull(){
        return (top==maxSize-1);
    }
}
public class StackApp {

    public static void main(String[] args) {

        int maxSize=10;
        StackX stack=new StackX(maxSize);
        Random r=new Random();
        boolean flag=true;
        while(flag){
            flag=false;
            if(!stack.isFull()){
                stack.push(r.nextInt(100));
                flag=true;
            }
            else
                System.out.println("stack is full");

        }
//        stack.push(33);
//        stack.push(44);
//        stack.push(66);
//        stack.push(55);
//        Random r=new Random();
//        while(!stack.isFull()) {
//            stack.push(r.nextInt(100));
//        }
//        long value=stack.peek();
//        System.out.println(value);

        while(!flag){
            flag=true;
            if(!stack.isEmpty()){
            Object value=stack.pop();
            System.out.println(value);
            flag=false;
            }
            else
                System.out.println("stack is empty");
        }
    }
}
