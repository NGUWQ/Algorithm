package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/28
 * \* Time: 1:07
 */

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 分析:
 * 跳1级台阶:1种跳法
 * 跳2级台阶:2种跳法
 * 跳3级台阶:4种跳法
 * 跳4级台阶:8种跳法
 *
 *
 * 即f(n)=2*f(n-1)
 */
public class Soulution10 {

        public static int JumpFloorII(int target) {
            int first=1,second=2,total=0;

            if (target<1)
                return -1;
            if (target==1)
                return first;
            else if (target==2)
                return second;
            else {
                for (int i=target;target>2;target--) {
                    total =2*second;
                    second=total;
                    //first = total;
                    //second = total;
                }
                return total;
            }
        }

    public static void main(String[] args) {

        System.out.println(JumpFloorII(5));
    }

}
