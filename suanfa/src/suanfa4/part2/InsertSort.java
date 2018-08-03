package suanfa4.part2;

import static utils.ArraysMethod.swap;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/27
 * \* Time: 12:51
 */
public class InsertSort {

    //插入排序 O(n^2)
    public void sort(int[] array){
        for (int i=1;i<array.length;i++){
            for (int j=i;j>0&&array[j]<array[j-1];j--)
                swap(array,j,j-1);
        }
    }

    //希尔排序(插入排序改进版) O(n^3/2)
    public void shellsort(int[] array){

        int h=1;
        while (h<array.length/3){
            h=h*3+1;
        }
        while (h>=1) {
            for (int i = h; i < array.length; i++) {

                for (int j = i; j >= h && array[j] < array[j - h]; j = -h)
                swap(array,j,j-h);
            }
            h=h/3;
        }
    }
}
