package leetcode.sort;

import shujujiegou.day6.Array;

import java.util.*;


/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/29
 * \* Time: 14:05
 */
/*
* 给定两个数组，写一个函数来计算它们的交集。

例子:

 给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].

提示:

每个在结果中的元素必定是唯一的。
我们可以不考虑输出结果的顺序。*/
public class Contain {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] array={};
        if (nums1.length==0||nums2.length==0||nums1==null||nums2==null)
            return array;
        Set<Integer> nums=new LinkedHashSet<>();
        Set<Integer> result=new LinkedHashSet<>();
        for (int i=0;i<nums1.length;i++){
            nums.add(nums1[i]);
        }
        for (int j=0;j<nums2.length;j++){
            if (nums.contains(nums2[j]))
                result.add(nums2[j]);
        }
        array=new int[result.size()];
        int i=0;
        for (int k:result)
            array[i++]=k;
        for (int k:array)
            System.out.println(k);
        return array;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int [] temp=new int[nums1.length];
        int i=0,j=0,index=0;
        while (i<nums1.length&&j<nums2.length){
            if (nums1[i]==nums2[j]){
                if (index==0||temp[index-1]!=nums1[i])
                    temp[index++]=nums1[i];
                i++;
                j++;
            }
            else if (nums1[i]<nums2[j])i++;
            else j++;
        }
        int[] result=new int[index];
        for (int k=0;k<index;k++)
        {result[k]=temp[k];}
        for (int k:result)
            System.out.println(k);
        return result;
    }


    public static void main(String[] args) {
        int[] n1={1};
        int[] n2={1};
        new Contain().intersection2(n1,n2);
    }
}
