package shujujiegou.day3;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/5
 * \* Time: 20:36
 */
//优先级队列(用数组实现)
class PriorityQueue{
    private long[] queue;
    private int maxSize;
    private int Items;

    public PriorityQueue(int s) {
        maxSize=s;
        queue=new long[maxSize];
        Items=0;
    }

    public void insert(long value) {
        int i;
        if (!this.isFull()) {
            if (Items == 0) {
                queue[Items++] = value;
            } else {
                for (i = Items - 1; i >= 0; i--) {
                    if (value > queue[i]) {
                        queue[i + 1] = queue[i];
                    } else
                        break;
                }
                queue[i + 1] = value;
                Items++;
            }
        }
        else {
            System.out.println("priority is full "+value+" can't insert!");
        }
    }

    public long remove(){
        if(!this.isEmpty()) {
            return queue[--Items];
        }
        else
            return -1;
    }

    public long peekMin(){
        return queue[Items-1];
    }

    public boolean isFull(){
        return (Items==maxSize);
    }

    public boolean isEmpty(){
        return (Items==0);
    }

}
public class PriorityQueueApp {

    public static void main(String[] args) {

        int maxSize=10;
        PriorityQueue priorityQueue=new PriorityQueue(maxSize);
        priorityQueue.insert(22);
        priorityQueue.insert(33);
        priorityQueue.insert(44);
        priorityQueue.insert(55);
        priorityQueue.insert(5);
        priorityQueue.insert(66);
        priorityQueue.insert(77);
        priorityQueue.insert(85);
        priorityQueue.insert(99);
        priorityQueue.insert(87);
        //priorityQueue.insert(83);
        long value=priorityQueue.peekMin();
        System.out.println(value);
//        while (true){
//            long value=priorityQueue.remove();
//            if (value==-1)
//                break;
//            System.out.println(value);
//        }

    }
}
