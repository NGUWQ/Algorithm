package leetcode.binarysearch;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/7/2
 * \* Time: 16:47
 */
//实现求根公式函数
public class Sqrt {
    public int mySqrt(int x) {
        if (x<=1) return x;
        int lo=1,hi=x;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            int sqrt=x/mid;
            if (sqrt==mid) return mid;
            else if (mid>sqrt)hi=mid-1;
            else lo=mid+1;
        }
        return hi;
    }

    public static void main(String[] args) {

        System.out.println(new Sqrt().mySqrt(8));
    }
}
