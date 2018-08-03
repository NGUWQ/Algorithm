package shujujiegou.day3;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/6
 * \* Time: 20:18
 */
class DuQueue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public DuQueue(int size) {
        maxSize = size;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insertLeft(long value) {
        if (front == 0) {
            front = maxSize;
        }
        queArray[--front] = value;
        nItems++;
    }

    public void insertRight(long value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = value;
        nItems++;
    }

    public long removeLeft() {
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long removeRight() {
        long temp = queArray[rear--];
        if (rear == -1) {
            rear = maxSize - 1;
        }
        nItems--;
        return temp;
    }

    public long peekLeft() {
        return queArray[front];
    }

    public long peekRight() {
        return queArray[rear];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }

    public void display() {
        System.out.print("队列为：");
        if (nItems == 0) {
            System.out.println("空。");
            return;
        }
        if (rear >= front) {
            for (int i = front; i <= rear; i++) {
                System.out.print(queArray[i] + " ");
            }
        } else {
            for (int i = front; i < maxSize; i++) {
                System.out.print(queArray[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(queArray[i] + " ");
            }
        }
        System.out.println();
    }
}

// ======================================================================

public class DuQueueApp {
    public static void main(String[] args) {
        DuQueue theQueue = new DuQueue(5); // queue holds 5 items
        System.out.println("队例是否为空：" + theQueue.isEmpty());
        System.out.println("队例是否为满：" + theQueue.isFull());
        System.out.println("队列的大小为：" + theQueue.size());
        theQueue.display();
        theQueue.insertRight(10); // insert 4 items
        theQueue.insertRight(20);
        theQueue.insertRight(30);
        theQueue.insertRight(40);
        System.out.println("队列的大小为：" + theQueue.size());
        theQueue.display();

        theQueue.removeLeft(); // remove 3 items
        theQueue.removeLeft(); // (10, 20, 30)
        theQueue.removeLeft();
        System.out.println("队列的大小为：" + theQueue.size());
        theQueue.display();

        theQueue.insertLeft(50); // insert 4 more items
        theQueue.insertLeft(60); // (wraps around)
        theQueue.insertLeft(70);
        theQueue.insertLeft(80);
        System.out.println("队例是否为空：" + theQueue.isEmpty());
        System.out.println("队例是否为满：" + theQueue.isFull());
        System.out.println("队列的大小为：" + theQueue.size());
        theQueue.display();

        theQueue.removeRight(); // remove 3 items
        theQueue.removeRight(); // (40, 50, 60)
        theQueue.removeRight();
        theQueue.removeRight();
        theQueue.removeRight();
        theQueue.removeRight();
        theQueue.removeRight();
        System.out.println("队列的大小为：" + theQueue.size());
        theQueue.display();

    } // end main()
} // end class QueueApp
