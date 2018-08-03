package leetcode.sort;

import java.util.*;

/*
* 给定两个数组，写一个方法来计算它们的交集。
例如:
给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
注意：
   输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
   我们可以不考虑输出结果的顺序。
跟进:
如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
*
* */
public class Contain2 {
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Map<Integer, Integer> map2 = new LinkedHashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                int count = map.get(nums1[i]);
                map.put(nums1[i], ++count);
            } else map.put(nums1[i], 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                if (map2.containsKey(nums2[i])) {
                    int count = map2.get(nums2[i]);
                    int counts = map.get(nums2[i]);
                    if (++count <= counts) {
                        map2.put(nums2[i], count);
                    } else {
                        map2.put(nums2[i], counts);
                    }
                } else map2.put(nums2[i], 1);
            }
        }
        int[] temp = new int[2 * map2.size()];
        int j = 0;
        for (int i : map2.keySet()) {
            temp[j++] = i;
            if (map2.get(i) != 1)
                temp[j++] =map2.get(i);
        }
        int[] result=new int[j];
        for (int i=0;i<j;i++)
            result[i]=temp[i];
        for (int k : result)
            System.out.println(k);
        return result;
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] temp = new int[nums1.length];
        int i = 0, j = 0, index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                temp[index++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = temp[k];
        }
        for (int k : result)
            System.out.println(k);
        return result;
    }

    public static void main(String[] args) {
        int[] n1 = {1,2,2,1};
        int[] n2 = {1,1};
        new Contain2().intersect(n1, n2);
    }
}
