package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/28
 * \* Time: 9:48
 */
/*
* 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
* 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
* 总共有多少种方法？
*
* 费波纳茨的应用
* 可用循环或者递归
* 此处用的是递归
* */
public class Solution11 {

    public int RectCover(int target) {
        if (target<1)
            return -1;
        else if(target==1)
            return 1;
        else if (target==2)
            return 2;
        else {
            return RectCover(target-2)+RectCover(target-1);
        }

    }
}
