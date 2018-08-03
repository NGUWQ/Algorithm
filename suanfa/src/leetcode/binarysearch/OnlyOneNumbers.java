package leetcode.binarysearch;

import java.util.HashSet;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/7/2
 * \* Time: 20:13
 */
//给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
public class OnlyOneNumbers {
    public int singleNonDuplicate(int[] nums) {
        int lo=0,hi=nums.length-1;
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if (mid%2==1)mid--;
            if (nums[mid]==nums[mid+1])lo=mid+2;
            else hi=mid;
        }
        return nums[lo];
    }
    public int singleNonDuplicate2(int[] nums) {
        int a=0;
        for (int i=0;i<nums.length;i++)
            a^=nums[i];
        return a;
    }

    public int singleNonDuplicate3(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (set.contains(nums[i])) set.remove(nums[i]);
            else set.add(nums[i]);
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {

        int[] nums={1,1,2,3,3,4,4,8,8};
        System.out.println(new OnlyOneNumbers().singleNonDuplicate3(nums));
    }
}
