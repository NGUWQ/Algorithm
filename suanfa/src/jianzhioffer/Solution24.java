package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/3
 * \* Time: 20:44
 */
/*
* 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
* 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。*/
public class Solution24 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int n=sequence.length;
        if (n==0)
            return false;
        int i=0;
        while (--n>=0)//循环判断每一个子树是否满足条件
        {
            while (sequence[i]<sequence[n])i++;
            while (sequence[i]>sequence[n])i++;
            if (i<n)
                return false;
            i=0;
        }
        return true;

    }
}
