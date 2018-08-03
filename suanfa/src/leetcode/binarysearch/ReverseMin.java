package leetcode.binarysearch;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/7/2
 * \* Time: 22:03
 */
/*
*假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
请找出其中最小的元素。
你可以假设数组中不存在重复元素。
* */

/*
* 如果用二分查找的话，当中间的值大于最右边的值的时候，
* 那么最小值一定在mid和right中间，当中间值小于最左边值的时候，
* 最小值一定在left和mid中间，只有当right mid 和 left的值相同的时候才无法确定
* 最小值在哪个区间，无法确定的时候让right的值 自减就好，因为right的一定是大于等于最小值的
*
* */
public class ReverseMin {
    public int findMin(int[] nums) {

        int lo=0,hi=nums.length-1;
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if (nums[mid]<=nums[hi])hi=mid;
            else lo=mid+1;
        }
        return nums[lo];
    }
    public int findMin2(int[] nums) //有重复
    {

        int lo=0,hi=nums.length-1;
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if (nums[mid]>nums[hi])lo=mid+1;
            else if (nums[mid]<nums[lo])hi=mid;
            else hi--;
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(new ReverseMin().findMin(nums));
    }
}
