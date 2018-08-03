package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/20
 * \* Time: 0:56
 */

/*
* 大家都知道斐波那契数列，现在要求输入一个整数n，
* 请你输出斐波那契数列的第n项。 n<=39
*/
public class Solution1 {
    public int Fibonacci(int n) {
        //这里判断n<=0是为了防止栈溢出
        if(n<=0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;
        else {
            if (n <= 39)
                return Fibonacci(n - 2) + Fibonacci(n - 1);
            else
                return 0;

        }
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int result=s.Fibonacci(6);
        System.out.println(result);
    }
}