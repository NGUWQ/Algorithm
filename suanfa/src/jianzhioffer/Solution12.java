package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/28
 * \* Time: 11:37
 */
//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
public class Solution12 {
    public int NumberOf1(int n) {
        int count = 0;

        if (n < 0) {
            String s = Integer.toBinaryString(n);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '1')
                    count++;
            }
            return count;
        } else if (n == 0) {
            return 0;
        } else {
            count = binnary(n);
            return count;

        }

    }

    private int binnary(int n) {
        int count = 0;
        while (n > 0) {
            int m = n % 2;
            if (m == 1)
                count++;
            n = n / 2;
        }
        return count;
    }


    //方法二:空间和时间更小
    public int NumberOf2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution12 s = new Solution12();
        System.out.println(s.NumberOf1(-6));
        System.out.println(s.NumberOf2(-6));
    }


}
