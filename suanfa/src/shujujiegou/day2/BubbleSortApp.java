package shujujiegou.day2;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/3
 * \* Time: 20:20
 */
//冒泡排序
class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 0; out--) {
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1])
                    swap(in, in + 1);
            }
        }
    }

    //编程作业3.1
    public void bubbleSort1(){
        int leftout=0,rightout=nElems-1,in;//leftout,rightout为左右两端指针
        for(;rightout>leftout;rightout--,leftout++){
            for(in=leftout;in<rightout;in++)
                if (a[in]>a[in+1])
                    swap(in,in+1);
            for(in=rightout-1;in>leftout;in--)
                if(a[in]<a[in-1])
                    swap(in,in-1);
        }
    }


    //编程作业3.4 奇偶排序
    public void oddEvenSort(){
        boolean change=true;
        while (change){
            change=false;
            for(int i=0;i<nElems-1;i+=2){
                if(a[i]>a[i+1]){
                    swap(i,i+1);
                    change=true;
                }
            }
            for(int j=1;j<nElems-1;j+=2){
                if(a[j]>a[j+1]){
                    swap(j,j+1);
                    change=true;
                }
            }
        }
    }


    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}

public class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr = new ArrayBub(maxSize);
        arr.insert(4);
        arr.insert(2);
        arr.insert(3);
        arr.insert(1);
        arr.insert(8);
        arr.insert(5);
        arr.insert(9);
        arr.insert(6);
        arr.display();
        arr.oddEvenSort();
        arr.display();
    }
}
