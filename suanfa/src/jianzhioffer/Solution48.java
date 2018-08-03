package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/19
 * \* Time: 19:20
 */
/*
* 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
* */
public class Solution48 {
    public int Add(int num1,int num2) {
//        while (num2!=0) {
//            int temp = num1 ^ num2;
//            num2 = (num1 & num2) << 1;
//            num1 = temp;
//        }
//        return num1;
        return num2!=0?Add(num1^num2,(num1&num2)<<1):num1;
    }

    public static void main(String[] args) {

        System.out.println(new Solution48().Add(-1,2));
    }
}
