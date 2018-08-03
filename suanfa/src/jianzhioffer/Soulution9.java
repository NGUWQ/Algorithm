package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/28
 * \* Time: 0:47
 */

/*
* 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
* 求该青蛙跳上一个n级的台阶总共有多少种跳法。
*
* 费波纳茨的应用,可用递归也可以用迭代,本处使用的迭代
* */
public class Soulution9 {

        public static int JumpFloor(int target) {

            int first=1,second=2,total=0;

            if (target<1)
                return -1;
            if (target==1)
                return first;
            else if (target==2)
                return second;
            else {
                for (int i=target;target>2;target--) {
                    total = first + second+1;
                    first = second;
                    second = total;
                }
                return total;
            }
        }

    public static void main(String[] args) {

        System.out.println(JumpFloor(4));
    }
}
