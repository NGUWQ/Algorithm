package shujujiegou.day3;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/6
 * \* Time: 17:19
 */
//编程作业4.2
class Deque{
    private long[] deque;
    private int front;
    private int rear;
    private int Items;
    private int maxSize;

    public Deque(int s)
    {
        maxSize=s;
        deque=new long[maxSize];
        Items=0;
        rear=-1;
        front=0;

    }

    public void insertRight(long value){
        if(!this.isFull()){
            if(rear==maxSize-1)
                rear=-1;
            deque[++rear]=value;
            Items++;
        }
        else
            System.out.println("deque is full");

    }

    public void insertLeft(long value){
            if(!this.isFull()){
                if(front==0){
                    front=maxSize;
                }
                deque[--front]=value;
                Items++;
            }
        else
            System.out.println("deque is full");
    }

    public long removeLeft(){
        long temp=-1;
        if(!this.isEmpty()){
            temp=deque[front++];
            if(front==maxSize)
                front=0;
            Items--;
            return temp;
        }
        else
            return temp;
    }

    public long removeRight(){
        long temp=-1;
        if(!this.isEmpty()){
            temp=deque[rear--];
            if(rear==-1)
                rear=maxSize-1;
            Items--;
            return temp;
        }
        else
            return temp;

    }

    public long peekRight(){
        return deque[front];

    }
    public long peekLeft(){
        return deque[rear];

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
public class DequeApp {
    public static void main(String[] args) {
        int maxSize=10;

        Deque deque=new Deque(maxSize);
        deque.insertRight(50);
        deque.insertRight(1);
        deque.removeLeft();
        deque.insertLeft(10);
        deque.insertLeft(20);
        deque.insertLeft(30);
        deque.insertLeft(40);
        deque.removeRight();
        deque.removeRight();
        System.out.println(deque.size());


//        long value=deque.peekLeft();
//        System.out.println(value);
        //System.out.println(deque.size());
//        while (true){
//            long value=deque.removeRight();
//            if (value==-1)
//                break;
//            System.out.println(value);
//        }
    }
}
/*
	//编程作业 4.2

 */