package shujujiegou.day10;

import java.io.IOException;
import java.util.Random;

import static utils.Get.*;

class Heap {

    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize)
    {
        heapArray = new Node[maxSize];
        this.maxSize = maxSize;
        currentSize = 0;
    }

    public boolean isEmpty() {

        return currentSize == 0;
    }

    public boolean insert(int value) {
        if (currentSize == maxSize)
            return false;
        Node node = new Node(value);
        heapArray[currentSize] = node;
        trickleUp(currentSize++);
        return true;
    }

    //编程作业12.2
    public void toss(int value)
    {
        Node node = new Node(value);
        heapArray[currentSize] = node;
        currentSize++;
    }

    public void restoreHeap(){
        for (int j=(currentSize/2)-1;j>=0;j--)
            trickleDown(j);

    }
    //---------------------------------------------------

    //编程作业12.1将trickleup,trickleDown,change方法的符号取反就行可用作作业12.3优先级队列
    private void trickleUp(int index) {

        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        while (index > 0 && heapArray[parent].getValue() < bottom.getValue()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (index - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        if (isEmpty())
            return null;
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;

    }

    private void trickleDown(int index) {

        int largerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild+ 1;

            if (rightChild<currentSize&&heapArray[leftChild].getValue() < heapArray[rightChild].getValue())
                largerChild = rightChild;
            else
                largerChild = leftChild;
            if (top.getValue() > heapArray[largerChild].getValue())
                break;
            else {
                heapArray[index] = heapArray[largerChild];
                index = largerChild;
            }
        }
        heapArray[index] = top;
    }

    public boolean change(int index, int newValue) {

        if (index < 0 || index >= currentSize)
            return false;
        int oldValue = heapArray[index].getValue();
        heapArray[index].setValue(newValue);
        if (oldValue < newValue)
            trickleUp(index);
        else
            trickleDown(index);
        return true;
    }

    public void displayHeap() {

        System.out.println("heapArray: ");
        for (int m = 0; m < currentSize; m++)
            if (heapArray[m] != null)
                System.out.println(heapArray[m].getValue() + " ");
            else
                System.out.println("-- ");
        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................................";
        System.out.println(dots + dots);

        while (currentSize > 0) {
            if (column == 0)
                for (int k = 0; k < nBlanks; k++)
                    System.out.print(' ');
            System.out.print(heapArray[j].getValue());
            if (++j == currentSize)
                break;
            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else
                for (int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(' ');
        }
        System.out.println("\n" + dots + dots);
    }
}

public class HeapApp {

    public static void main(String[] args) throws IOException {
        System.out.println("1.堆的显示(s or S)");
        System.out.println("2.堆数据的添加(i or I)");
        System.out.println("3.堆数据优先级的改变(c or C)");
        System.out.println("4.堆数据的删除(d or D)");
        System.out.println("5.退出程序(q or Q)");
        System.out.println("请输入堆的大小(size):");
        int size = getValue();
        System.out.println("请输入存入堆的的数据个数n(n<=size)");
        int n = getValue();

        Heap heap = new Heap(size);
        for (int j = 0; j < n; j++) {
            int value = new Random().nextInt(size * n);
            heap.insert(value);
        }
        while (true) {
            System.out.println("您想怎么操作堆呢?");
            char choice = getChoice();
            if (choice == 'q' || choice == 'Q')
                //heap.restoreHeap();
                break;
            else if (choice == 's' || choice == 'S') {
                heap.displayHeap();
            } else if (choice == 'd' || choice == 'D') {
                Node node = heap.remove();
                if (node == null)
                    System.out.println("没有此数据,删除失败！！！");
                else
                    System.out.println("删除成功！！！");
            } else if (choice == 'i' || choice == 'I') {
                System.out.println("请输入要添加的值:");
                int value = getValue();
                //heap.toss(value);
                boolean b = heap.insert(value);
                if (b == true)
                    System.out.println(value + "添加成功");
                else
                    System.out.println(value + "添加失败");
            }
            else if (choice == 'c' || choice == 'C') {
                System.out.println("输入要修改的位置的值:");
                int index = getValue();
                int value = getValue();
                boolean b =heap.change(index,value);
                if (b == false)
                    System.out.println("更改失败!!!");
                else
                    System.out.println("更改成功");
            } else
                System.out.println("请重新输入!!!");

        }

    }
}
