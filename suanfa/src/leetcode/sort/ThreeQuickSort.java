package leetcode.sort;

import static utils.ArraysMethod.swap;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/7/2
 * \* Time: 11:21
 */
/*
*
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。(考察三项切分)
* */
public class ThreeQuickSort {
    public void sortColors(int[] nums) {

        int zero=-1,one=0,two=nums.length;
        while (one<two){
            if (nums[one]==0) swap(nums,++zero,one++);
            else if (nums[one]==2)swap(nums,one,--two);
            else one++;
        }
    }

    public static void main(String[] args) {
        int[] nums={0,1,0,2,2,1,0};
        new ThreeQuickSort().sortColors(nums);
    }
}
