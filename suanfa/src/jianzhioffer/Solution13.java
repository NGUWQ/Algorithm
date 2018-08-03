package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/28
 * \* Time: 14:47
 */
/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 */
public class Solution13 {
    public double Power(double base, int exponent) {

        double sum=1.0;
        if (base==0.0)
            return 0.0;
        else if (base!=0.0&&exponent==0)
            return 1.0;
        else {
            while (exponent>0){
                sum*=base;
                exponent--;
            }
            while (exponent<0)
            {
                sum/=base;
                exponent++;
            }
            return sum;
        }

        //return Math.pow(base,exponent);
    }

    public static void main(String[] args) {

        Solution13 s=new Solution13();
        System.out.println(s.Power(2,-3));
    }
}
