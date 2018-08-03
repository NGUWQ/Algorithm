package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/20
 * \* Time: 1:35
 */
/*
* 求1+2+3+...+n，
* 要求不能使用乘除法、for、while、if、else、switch、case
* 等关键字及条件判断语句（A?B:C）。
* */
public class Solution2 {
    public static int Sum_Solution1(int n) {
        int sum=(int)(Math.pow(n,2)+n);
        return sum>>1;
    }

    public static int Sum_Solution2(int n) {
        int sum=n;
        boolean bl=((n>0)&&(sum+=Sum_Solution2(n-1))>0);
        return sum;
    }
    public static int Sum_Solution3(int n) {
        int sum=0,a=n,b=n+1;
        while (a!=0){
            if ((a&1)==1)
                sum+=b;
            a=a>>1;
            b=b<<1;
        }
        return sum>>1;
    }
    public static int Sum_Solution4(int n) {
        return muti(n,n+1)>>1;
    }

    private static int muti(int a, int b) {
        int sum=0;
        boolean b1=((a&1)==1)&&(sum+=b)>0;
        a=a>>1;
        b=b<<1;
        boolean b2=(a!=0)&&(sum+=muti(a,b))>0;
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(Sum_Solution1(5));
        System.out.println(Sum_Solution4(6));
    }
}