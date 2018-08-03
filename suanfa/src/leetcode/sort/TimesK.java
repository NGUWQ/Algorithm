package leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/30
 * \* Time: 22:10
 */
/*
* 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
例如，
给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。(桶排序)
*
* */
public class TimesK {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                int count=map.get(nums[i]);
                map.put(nums[i],count+1);
            }
            else map.put(nums[i],1);
        }
        List<Integer>[] lists=new ArrayList[nums.length+1];
        for (int key:map.keySet()){
            int counts=map.get(key);
            if (lists[counts]==null){
                lists[counts]=new ArrayList<>();
            }
            lists[counts].add(key);
        }
        List<Integer> al=new ArrayList<>();
        for (int i=lists.length-1;i>=0&&al.size()<k;i--){
            if (lists[i]!=null)
                al.addAll(lists[i]);
        }
        return al;
    }

    public static void main(String[] args) {
        int[] array={1,1,1,1,1};
        List<Integer> list=new TimesK().topKFrequent(array,9);
        System.out.println(list);
    }
}
