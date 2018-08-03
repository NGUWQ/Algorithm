package leetcode.binarysearch;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/7/4
 * \* Time: 9:45
 */
/*
* 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
* 找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。*/
public class Search {
    public int[] searchRange(int[] nums, int target) {
        int first=binaryRearch(nums,target);
        int last=binaryRearch(nums,target+1)-1;
        if (first==nums.length||nums[first]!=target)
            return new int[]{-1,-1};
        else
            return new  int[]{first,Math.max(first,last)};
    }
    public int binaryRearch(int[] nums, int target) {
        int lo=0,hi=nums.length;
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if (nums[mid]>=target)hi=mid;
            else lo=mid+1;
        }
        return lo;
    }

    public static void main(String[] args) {

        int[] nums={5,7,7,8,8,10};
        System.out.println(new Search().searchRange(nums,8)[1]);
    }
}
