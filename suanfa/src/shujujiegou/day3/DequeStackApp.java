package shujujiegou.day3;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/6
 * \* Time: 22:06
 */
//编程作业4.3
class DequeStack{
    private long[] deque;
    private int front;
    private int rear;
    private int maxSize;
    private int Items;

    public DequeStack(int s){
        maxSize=s;
        deque=new long[maxSize];
        front=0;
        rear=-1;
        Items=0;
    }

    public void insert(long value){
        if(!this.isFull()){
            deque[++rear]=value;
            Items++;
        }
    }

    public long remove(){
        long temp=-1;
        if(!this.isEmpty()){
            temp=deque[rear--];
            Items--;
            return temp;
        }
        else
            return temp;
    }

    private boolean isEmpty() {
        return (Items==0);
    }

    private boolean isFull() {
        return (Items==maxSize);
    }
}
public class DequeStackApp {
    public static void main(String[] args) {
        int maxSize=10;
        DequeStack dequeStack=new DequeStack(maxSize);
        dequeStack.insert(22);
        dequeStack.insert(33);
        dequeStack.insert(44);
        dequeStack.insert(55);
        dequeStack.insert(66);
        dequeStack.insert(77);
        dequeStack.insert(88);
        dequeStack.insert(99);

        while (true){
            long value=dequeStack.remove();
            if (value==-1)
                break;
            System.out.println(value);
        }
    }
}
