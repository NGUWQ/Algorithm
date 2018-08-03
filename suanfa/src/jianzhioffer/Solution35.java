package jianzhioffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/8
 * \* Time: 15:12
 */
/*
* 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
* 并返回它的位置
*
* 考虑空间时间复杂度
* 思路：
* 1.将字符串放进map集合中，存储每个字符所出现的次数.
* 2.遍历字符串和map集合,得到第一个出现的字符.
*
* */
public class Solution35 {
    public int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map=new LinkedHashMap<Character, Integer>();
        int times;
        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if (map.containsKey(c))
            {
                times=map.get(c);
                map.put(c,++times);
            }
            else {
                map.put(c,1);
            }
        }
        int pos=-1;
        int i=0;
        for (;i<str.length();i++){
            char c=str.charAt(i);
            if (map.get(c)==1)
                return i;
        }
        return pos;
    }

    public static void main(String[] args) {
        String str="abcabce";
        System.out.println(new Solution35().FirstNotRepeatingChar(str));
    }
}
