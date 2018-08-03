package leetcode.binarysearch;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/7/2
 * \* Time: 19:51
 */
/*
* 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。

数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z'
并且有序数组为 letters = ['a', 'b']，则答案返回 'a',target = 'a',则答案返回 'b'。
* */
public class CharacerMin {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length-1])
            return letters[0];
        int lo = 0, hi = letters.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] > target) hi = mid;
            else lo = mid + 1;
        }
            return letters[lo];
    }

    public static void main(String[] args) {

        char[] letters = {'c', 'f', 'j'};
        System.out.println(new CharacerMin().nextGreatestLetter(letters, 'k'));
    }
}
