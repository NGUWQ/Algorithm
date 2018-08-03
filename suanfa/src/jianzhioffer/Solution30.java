package jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/5
 * \* Time: 22:26
 */
/*
* 输入n个整数，找出其中最小的K个数。
* 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,*/
public class Solution30 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        if (input.length==0||k<0||k>input.length)
            return arrayList;
        Arrays.sort(input);
        for (int i=0;i<k;i++)
            arrayList.add(input[i]);
        return arrayList;
    }
    int[] array;
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        array=input;
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        if (input.length==0||k<0||k>input.length)
            return arrayList;
        reQuickSort(0,input.length-1);
        for (int i=0;i<k;i++)
            arrayList.add(array[i]);
        return arrayList;
    }

    private void reQuickSort(int left, int right) {
        int size=right-left+1;
        if (size<10)
            insertSort(left,right);
        else {
            int pivot=media(left,right);
            int par=partition(left,right,pivot);
            reQuickSort(left,par-1);
            reQuickSort(par+1,right);

        }
    }

    private int partition(int left, int right, int pivot) {
        int leftPr=left;
        int rightPr=right;
        while (true){
            while (array[++leftPr]<pivot)
                ;
            while (array[--rightPr]>pivot)
                ;
            if (leftPr>rightPr)
                break;
            else {
                swap(leftPr,rightPr);
            }
        }
        swap(leftPr,right-1);
        return leftPr;
    }

    private void swap(int left, int right) {
        int temp=array[left];
        array[left]=array[right];
        array[right]=temp;
    }

    private int media(int left, int right) {
        int center=(left+right)/2;
        if (array[left]>array[center])
            swap(left,center);
        if (array[left]>array[right])
            swap(left,right);
        if (array[center]>array[right])
            swap(center,right);
        swap(center,right-1);
        return array[right-1];
    }

    private void insertSort(int left, int right) {
        int out,in;
        for (out=left+1;out<=right;out++){
            int temp=array[out];
            in=out;
            while (in>0&&array[in-1]>temp){
                array[in]=array[in-1];
                --in;
            }
            array[in]=temp;
        }
    }

    public static void main(String[] args) {

        int [] array={1,2,3,4,9,8,7,6,5};
        System.out.println(new Solution30().GetLeastNumbers_Solution1(array,7));
    }
}
