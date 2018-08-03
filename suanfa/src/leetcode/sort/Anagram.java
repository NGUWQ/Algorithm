package leetcode.sort;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/30
 * \* Time: 15:43
 */
/*给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。*/
public class Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] sArray = new int[26];
        int[] tArray = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sArray[s.charAt(i) - 97]++;
            tArray[t.charAt(i) - 97]++;
        }

        for (int i = 0; i < 26; i++)
            if (sArray[i] != tArray[i])
                return false;

        return true;
    }

    public static void main(String[] args) {

        String s1="anagram";
        String s2="nagaram";
        new Anagram().isAnagram(s1,s2);
    }
}