package jianzhioffer;

import day6.Array;

import java.util.ArrayList;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/28
 * \* Time: 15:05
 */

/*
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。*/
public class Solution14 {

    public void reOrderArray1(int[] array) {
        ArrayList<Integer> arrayList1=new ArrayList<Integer>();
        ArrayList<Integer> arrayList2=new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                arrayList1.add(array[i]);//偶数
            }
            else {
                arrayList2.add(array[i]);//奇数
            }
        }

        for (int i=0;i<arrayList1.size();i++){

            int value=arrayList1.get(i);
            arrayList2.add(value);
        }
        System.out.println(arrayList2);
    }

    public void reOrderArray2(int[] array) {
        for(int i= 0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]%2==0&&array[j+1]%2==1){
                    int t = array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
    }


    public static void main(String[] args) {

        Solution14 s=new Solution14();
        int[] array={1,2,3,4,5,6,7};
        s.reOrderArray2(array);

    }
}
