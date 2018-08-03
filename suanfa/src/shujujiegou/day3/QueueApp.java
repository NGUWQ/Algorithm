package shujujiegou.day3;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/5
 * \* Time: 18:29
 */
//循环队列
class Queue{
    private long[] queue;
    private int front;
    private int rare;
    private int Items;
    private int maxSize;

    public Queue(int s){
        maxSize=s;
        queue=new long[maxSize];
        front=0;
        rare=-1;
        Items=0;
    }

    public void insert(long value){
        if (!this.isFull()) {
            if (rare == maxSize - 1)
                rare = -1;
            queue[++rare] = value;
            Items++;
        }
        else
            System.out.println("queue is full");
    }

    public long remove(){
        long temp=-1;
        if (!this.isEmpty()) {
             temp=queue[front++];
            if (front == maxSize)
                front = 0;
            Items--;
            return temp;
        }
        else
            return temp;

    }

    //编程作业4.1
    public void display(){
        System.out.print("队列为: ");
        if (Items==0)
            System.out.println("空");
        else if(rare>=front)//rare>front说明队列没有分段
        {
            for(int i=0;i<=rare;i++){
                System.out.print(queue[i]+" ");
            }
            System.out.println();
        }
        else {
            for(int i=front;i<maxSize;i++)//分段后就是两个序列，即分别对front和rare分别做遍历
            {
                System.out.print(queue[i]+" ");
            }
            for(int i=0;i<=rare;i++){
                System.out.print(queue[i]+" ");
            }
            System.out.println();
        }
    }

    public long peekFront(){
        return queue[front];
    }

    public boolean isEmpty(){
        return (Items==0);
    }

    public boolean isFull(){
        return (Items==maxSize);
    }

    public int size(){
        return Items;
    }
}
public class QueueApp {

    public static void main(String[] args) {
        Queue q=new Queue(7);
        q.insert(33);
        q.insert(44);
        q.insert(55);
        q.insert(66);
        q.insert(42);
        q.insert(42);
        q.remove();
        q.remove();
        q.insert(111);
        q.insert(222);
        q.display();
//        System.out.println(q.size());
//        q.remove();
//        q.remove();
//        System.out.println(q.size());
//        q.insert(22);
//        q.insert(11);
//        System.out.println(q.size());
//        while (!q.isEmpty()){
//            long value=q.remove();
//            System.out.println(value);
//      }
    }
}
