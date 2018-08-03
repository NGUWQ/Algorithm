package suanfa4.part2;

import static utils.ArraysMethod.swap;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/27
 * \* Time: 22:15
 */
//快速排序(nlgn)原地排序
public class QuickSort {
    int[] array={2,1,3,5,6,4,7,7};

    public void sort(){
        sort(array,0,array.length-1);
        for (int i:array)
            System.out.print(i+" ");
    }

    public void sort(int[] array,int lo,int hi){
        if (lo>=hi)return;
        int j=Parition(array,lo,hi);
        sort(array,lo,j-1);
        sort(array,j+1,hi);
    }

    private int Parition(int[] array, int lo, int hi) {
        int i=lo,j=hi+1;
        int temp=array[lo];
        while (true){
            while (array[++i]<temp);
            while (array[--j]>temp);
            if (i>=j) break;
            else swap(array,i,j);
        }
        swap(array,lo,j);
        return j;
    }

    public static void main(String[] args) {

        QuickSort q=new QuickSort();
        q.sort();
    }
}
