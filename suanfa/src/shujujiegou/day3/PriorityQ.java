package shujujiegou.day3;

import java.util.Iterator;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/7
 * \* Time: 0:21
 */
//编程作业4.4
class Priority{
    private long[] priority;
    private int maxSize;
    private int Items;

    public Priority(int s){
        maxSize=s;
        priority=new long[maxSize];
        Items=0;
    }

    public void insert(long value){
        if(!this.isFull())
            priority[Items++]=value;
    }

    public long remove() {
        int highPriority = 0;
        if (!this.isEmpty()) {
            for (int i = 1; i < Items; i++) {
                if (priority[i] < priority[highPriority])
                    highPriority = i;
            }
            long temp = priority[highPriority];
            Items--;
            for (int i = highPriority; i < Items; i++) {
                priority[i] = priority[i + 1];
            }
            return temp;
        }
        else
            return -1;
    }

    public void display()//插入队列的顺序
    {
        System.out.print("对列为：");
        for(int i=0;i<Items;i++)
            System.out.print(priority[i]+" ");
        System.out.println();
    }

    public void displays()//按优先级的顺序
    {
        int out,in;
        for(out=1;out<Items;out++){
            long temp=priority[out];
            in=out;
            while(in>0&&priority[in-1]>temp){
                priority[in]=priority[in-1];
                --in;
            }
            priority[in]=temp;
        }
        System.out.print("队列为：");
        for(int i=0;i<Items;i++)
            System.out.print(priority[i]+" ");
        System.out.println();
    }

    public boolean isEmpty(){
        return (Items==0);
    }

    public boolean isFull(){
        return (Items==maxSize);
    }
}
public class PriorityQ {

    public static void main(String[] args) {

        int maxSize=10;
        Priority priority=new Priority(maxSize);
        priority.insert(11);
        priority.insert(33);
        priority.insert(22);
        priority.insert(66);
        priority.insert(44);
        priority.insert(55);

//        while (true){
//            long value=priority.remove();
//            if (value==-1)
//                break;
//            System.out.println(value);
//        }
        priority.display();
        priority.displays();



    }
}
