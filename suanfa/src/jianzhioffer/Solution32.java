package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/6
 * \* Time: 15:56
 */
/*求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。*/
public class Solution32 {

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while (n > 0) {
            String str = String.valueOf(n);
            char[] array = str.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (array[i] == '1')
                    count++;
            }
            --n;
        }
        return count;
    }

    public int NumberOf1Between1AndN_Solution1(int n) {
        if (n <= 0)
            return 0;
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(new Solution32().NumberOf1Between1AndN_Solution1(150));
    }
}
