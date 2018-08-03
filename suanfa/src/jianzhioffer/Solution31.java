package jianzhioffer;

import day6.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/6
 * \* Time: 0:28
 */
/*HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
今天测试组开完会后,他又发话了:
在古老的一维模式识别中,常常需要计算连续子向量的最大和,
当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,
是否应该包含某个负数,并期望旁边的正数会弥补它呢？
例如:{6,-3,-2,7,-15,1,2,2},
连续子向量的最大和为8(从第0个开始,到第3个为止)。
你会不会被他忽悠住？(子向量的长度至少是1)
* */
/*
* 思路:(空间和时间复杂度都比较好)
* 用数组列表存放数组的内容,并且每求完一轮的值就移除第一个下标,进行下一轮求和,
* 将每一轮所求的和存入另一个数组列表,找出最大值,放入最终的数组列表中,从而求出连续子向量的最大值
* */
public class Solution31 {
    //方法一：
    public int FindGreatestSumOfSubArray(int[] array) {
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();//用来存放数组的元素
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();//用来存放每一轮最大的元素
        int k = 0;//控制轮数
        if (array.length==0)
            return -1;
        for (int i = 0; i < array.length; i++) {
            arrayList1.add(array[i]);
        }
        while (k <= array.length - 1) {
            int sum = 0;
            ArrayList<Integer> arrayList2 = new ArrayList<Integer>();//过渡数组列表,用来存放每一轮的连续子向量的值
            for (Integer i : arrayList1) {
                sum += i;
                arrayList2.add(sum);
            }
            int sums = arrayList2.get(0);//获取第一个元素值,并与后面的元素进行比较,从而得出这一轮的最大值
            for (int i = 1; i < arrayList1.size(); i++) {
                if (sums < arrayList2.get(i))
                    sums = arrayList2.get(i);
            }
            arrayList3.add(sums);//将最大值加入到最终的数组列表中
            arrayList1.remove(0);//每一次都移除第一个元素
            ++k;
        }
        k= arrayList3.get(0);//获取第一个元素,并与列表中其他元素比较,从而得出最大的连续子向量的值
        for (int i = 1; i < arrayList3.size(); i++) {
            if (k < arrayList3.get(i))
                k = arrayList3.get(i);
        }
        return k;

    }
    /*
    方法二：时间和空间比法1要大
    public int FindGreatestSumOfSubArray2(int[] array) {
        List<Integer> list1=new ArrayList<Integer>();
        List<Integer> list2=new ArrayList<Integer>();
        if (array.length==0)
            return -1;
        for (int i=0;i<array.length;i++)
        {
            int sum=0;
            for (int j=i;j<array.length;j++)
            {
                sum+=array[j];
                list1.add(sum);
            }
            sum=list1.get(0);
            for (int k=1;k<list1.size();k++)
                if (sum<list1.get(k))
                    sum=list1.get(k);
            list2.add(sum);
        }
        int max=list2.get(0);
        for (int k=1;k<list2.size();k++)
            if (max<list2.get(k))
                max=list2.get(k);
        return max;
    }
    */
    //动态规划
    public int FindGreatestSumOfSubArray2(int[] array){
        if (array.length==0)
            return 0;
        int sum=array[0];
        int tempsum=array[0];
        for (int i=1;i<array.length;i++){
            tempsum=(tempsum<0)?array[i]:tempsum+array[i];
            sum=(sum>tempsum)?sum:tempsum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array ={6,-3,-2,7,-15,1,2,2};
        System.out.println(new Solution31().FindGreatestSumOfSubArray2(array));
    }
}
