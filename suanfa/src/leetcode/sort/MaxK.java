package leetcode.sort;

import java.util.PriorityQueue;

import static utils.ArraysMethod.swap;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/30
 * \* Time: 17:11
 */
/*
* 在未排序的数组中找到第 k 个最大的元素。（快排）
* 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。*/
public class MaxK {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
//        for (int i:nums)
//            System.out.println(i);
        return nums[nums.length-k];
    }

    private void quickSort(int[] nums, int lo, int hi) {
        if (hi<=lo)return;
        int p=parition(nums,lo,hi);
        quickSort(nums,lo,p-1);
        quickSort(nums,p+1,hi);
    }

    private int parition(int[] nums, int lo, int hi) {
        int i=lo,j=hi+1;
        int temp=nums[lo];
        while (true) {
            while (nums[++i] < temp) if (i==hi) break;
            while (nums[--j] > temp) if (j==lo) break;
            if (i >= j)break;
            else swap(nums,i,j);
        }
        swap(nums,lo,j);
        return j;
    }

    public int findKthLargest2(int[] nums, int k){
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for (int i:nums){
            queue.add(i);
            if (queue.size()>k)
                queue.poll();
        }
        return queue.peek();
    }

    public int findKthLargest3(int[] nums, int k){
        if (nums.length==0||nums==null||k<1)
            return -1;
        k=nums.length-k;
        int lo=0,hi=nums.length-1;
        while (lo<hi){
            int p=parition(nums,lo,hi);
            if (p==k)break;
            else if (p>k)hi=p-1;
            else lo=p+1;
        }
        return nums[k];
    }

    public static void main(String[] args) {

        int[] array={1,2,3,4};
        System.out.println(new MaxK().findKthLargest3(array,1));
    }
}
