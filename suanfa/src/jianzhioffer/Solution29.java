package jianzhioffer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/5
 * \* Time: 21:20
 */
/*
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。*/
public class Solution29 {
    public int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int key = 0;//返回的数组中的值
        int value = 1;//map集合中键出现的次数
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                Integer values = map.get(array[i]);
                values++;
                map.put(array[i], values);

            } else
                map.put(array[i], value);

        }
        //Set<Integer> set=map.keySet();
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            if (map.get(key) > array.length / 2)
                break;
            else
                key = 0;
        }
        return key;

    }

    public static void main(String[] args) {

        int[] array = {1, 2, 2, 3, 2, 2};
        System.out.println(new Solution29().MoreThanHalfNum_Solution(array));
    }
}
