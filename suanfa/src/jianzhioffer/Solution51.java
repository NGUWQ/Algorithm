package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/20
 * \* Time: 20:32
 */
/*
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * */
public class Solution51 {
    public int[] multiply(int[] A) {
        /*int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            //计算下三角连乘
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            //计算上三角
            for (int j = length - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;*/
        int[] B = new int[A.length];
        boolean changed = false;
        for (int k = 0; k < B.length; k++) {
            B[k] = 1;
            for (int i = 0; i < A.length; i++) {
                int temp = 1;
                if (i == k) {
                    changed = true;
                    temp = A[i];
                    A[i] = 1;
                }
                B[k] *= A[i];
                if(changed){
                    A[i] =temp;
                    changed = false;
                }
            }

        }
        return B;
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = new Solution51().multiply(a);
        for (int i : b)
            System.out.println(i);
    }
}