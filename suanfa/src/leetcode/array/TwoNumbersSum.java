package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/30
 * \* Time: 13:35
 */
/*
*
给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用*/
public class TwoNumbersSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            result[0] = i;
            int temp = target - nums[i];
            int j = i + 1, hi = nums.length - 1;
            while (j < nums.length) {
                if (temp == nums[j]) {
                    result[1] = j;
                }
                j++;
            }
            if (result[1] != 0) break;
        }
//        for (int k: result)
//            System.out.println(k);
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                result[0] = map.get(num);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
//        for (int k : result)
//            System.out.println(k);
        return result;
    }
    public int[] twoSum3(int[] nums, int target) {
        int[] answer = new int[2];
        if(nums == null|| nums.length < 2){
            return answer;
        }
        int min = nums[0];
        int max = nums[0];

        for(int i = 0 ;i< nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }
        int[] difference = new int[max - min +1];
        for(int i = 0 ;i < nums.length; i++){

            int other = target - nums[i];
            if(other < min || other > max){
                continue;
            }
            if(difference[other - min] > 0){
                answer[0] = difference[other - min] -1;
                answer[1] = i;
                return answer;
            }
            difference[nums[i] - min] = i+1;
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 7, 11, 15};
        new TwoNumbersSum().twoSum3(nums, 26);

    }
}
