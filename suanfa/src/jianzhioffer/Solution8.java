package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/28
 * \* Time: 0:10
 */
/*
* 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
* 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
* 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
* NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。*/

//需要优化
import java.util.ArrayList;

public class Solution8 {
    public static int minNumberInRotateArray(int[] array) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }
        if (arrayList.size() == 0 || arrayList.contains(0))
            return 0;
        else {
            int value = arrayList.get(0);
            for (int i = 1; i < arrayList.size(); i++) {
                if (value > arrayList.get(i))
                    value = arrayList.get(i);
            }
            return value;
        }
    }

    public int Fibonacci(int n) {

        if(n<=0)
            return n;
        else if (n==1||n==2)
            return 1;
        else {
            return Fibonacci(n-2)+Fibonacci(n-1);
        }

    }

    public static void main(String[] args) {

        int[] array={3,4,5,2,3};
        System.out.println(minNumberInRotateArray(array));
    }
}