package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/21
 * \* Time: 14:22
 */
/*
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * */
public class Solution54 {
    char[] hashtable = new char[256];
    String s = "";

    //Insert one char from stringstream
    public void Insert(char ch) {
        s += ch;
        hashtable[ch]++;

    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (hashtable[s.charAt(i)] == 1)
                return s.charAt(i);
        }
        return '#';
    }

    LinkedHashMap<Character, Integer> hash = new LinkedHashMap<Character, Integer>();

    public void Insert1(char ch) {
        hash.put(ch, hash.containsKey(ch) ? 1 : 0);
    }

    public char FirstAppearingOnce1() {
        for (Map.Entry<Character, Integer> key : hash.entrySet()) {
            if (key.getValue() == 0)
                return key.getKey();
        }
        return '#';
    }


    public static void main(String[] args) {

        Solution54 s = new Solution54();
        char[] c = "googgle".toCharArray();
        for (int i = 0; i < c.length; i++)
            s.Insert1(c[i]);
        System.out.println(s.FirstAppearingOnce1());
    }
}
