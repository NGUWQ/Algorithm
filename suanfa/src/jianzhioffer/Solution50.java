package jianzhioffer;

import java.util.Arrays;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/20
 * \* Time: 15:32
 */
/*
* 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
* 数组中某些数字是重复的，但不知道有几个数字是重复的。
* 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
* 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
* */
public class Solution50 {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {

        if (length<=0||numbers==null)
            return false;
        for (int i=0;i<numbers.length;i++){
            if (numbers[i]>length)
                return false;
        }
        Arrays.sort(numbers);
        int left = 0;
        int right = length - 1;
        while (left<right) {
            int rights=right;
            while (left < rights) {
                int mid = (left + rights) / 2;
                if (numbers[left] < numbers[rights])
                    rights = mid;
                else {
                    duplication[0] = numbers[left];
                    return true;
                }
            }
            left++;
        }
        return false;
    }

    //剑指offer思路
    public boolean duplicate1(int numbers[],int length,int [] duplication) {

        if (numbers==null||length<=0)
            return false;
        for (int i=0;i<numbers.length;i++){
            if (numbers[i]>length)
                return false;
        }
        for (int j=0;j<length;j++){
            while (numbers[j]!=j){
                if (numbers[j]==numbers[numbers[j]]){
                    duplication[0]=numbers[j];
                    return true;
                }
                int temp=numbers[j];
                numbers[j]=numbers[temp];
                numbers[temp]=temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] array={6,3,4,0,2,5,3};
        int[] arrays=new int[1];
        System.out.println(new Solution50().duplicate1(array,7,arrays));
    }
}
