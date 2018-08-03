package jianzhioffer;

import java.util.ArrayList;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/14
 * \* Time: 9:40
 */
/*
* 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
* 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
* */

/*思路:数组时递增的,我们先排除数组中>=sum的那些数,他们不满足条件.将满足条件的数存储起来,
那么我们先从头和尾找满足的数 设i=0,即数组的第一个值,j=list.size()-1,
即数组的最后一个值。那么有三种情况:
1.sum>0,说明数组头的数字太小,即++i;j值不变
2.sum<0,说明array[j]的值太小,j--
3.sum=0,得到满足的两个值,并存储
4.将每一次满足3的两个值的乘积和上一次的做比较,如果满足条件就保存.

递增数组:越靠近两端的数字乘积小于靠近中间的两数字乘积
*/


public class Solution43 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<Integer> list2=new ArrayList<Integer>();
        if (array.length==0||array==null)
            return list2;
        for (int i=0;i<array.length;i++){
            if (array[i]<sum)
                list.add(array[i]);
        }
        int i=0,j=list.size()-1;
        while (i<j) {
            int temp=sum;
            temp -= list.get(i) + list.get(j);
            if (temp == 0) {
                list2.add(list.get(i));
                list2.add(list.get(j));
                return list2;
            }
            else if (temp > 0) {
                i++;
            }
            else
                j--;
        }
            return list2;
    }
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,7,11,15};

        System.out.println(new Solution43().FindNumbersWithSum(array,15));
    }
}
