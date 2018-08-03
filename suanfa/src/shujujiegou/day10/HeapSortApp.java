package shujujiegou.day10;

import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/26
 * \* Time: 15:37
 */
//堆排序(对任意顺序的数据,排序时间复杂度都是O(N*logN))
class HeapSort {
    private Node[] array;
    private int currentSize;
    private int maxSize;

    public HeapSort(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
        array = new Node[maxSize];
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public void insert(Node node) {
        if (!isFull()) {
            array[currentSize]=node;
            ++currentSize;
        }
        else
            System.out.println("空间已满,不能添加！");
    }

    public void insertAt(int index,Node node){
        if (index==maxSize)
            System.out.println("空间已满,不能添加！");
        else {
            array[index]=node;
        }
    }

    public Node remove() {
        if (isEmpty())
            return null;
        else
            {
            Node root = array[0];
            array[0] = array[--currentSize];
            tricleDown(0);
            return root;
        }
    }

    public void tricleDown(int index) {
        int largerChild;
        Node top = array[index];
        while (index<currentSize/2){

            int leftChild=2*index+1;
            int rightChild=leftChild+1;
            if (rightChild<currentSize&&array[leftChild].getValue()
                    <array[rightChild].getValue())
                largerChild=rightChild;
            else
                largerChild=leftChild;

            if (top.getValue()>array[largerChild].getValue())
                break;
            array[index]=array[largerChild];
            index=largerChild;
        }
        array[index]=top;
    }

    public void display(){
        for (int i=0;i<maxSize;i++)
            System.out.print(array[i].getValue()+" ");
        System.out.println();
    }

}

public class HeapSortApp {

    public static void main(String[] args) {

        int max=10;
        HeapSort heapSort=new HeapSort(max);
        for (int i=0;i<max;i++)
            heapSort.insert(new Node(new Random().nextInt(100)));
        heapSort.display();

        for (int j=(max/2)-1;j>=0;j--)
            heapSort.tricleDown(j);
        heapSort.display();

        for (int j=max-1;j>=0;j--) {
            Node data=heapSort.remove();
            heapSort.insertAt(j, data);
        }
        heapSort.display();



    }
}
