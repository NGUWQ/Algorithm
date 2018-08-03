package jianzhioffer;
import java.util.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/7
 * \* Time: 19:36
 */
/*
把只包含因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含因子7。
习惯上我们把1当做是第一个丑数。
求按从小到大的顺序的第N个丑数。
* */
public class Solution34 {

    public int GetUglyNumber_Solution(int index) {
        if (index<=0)
            return 0;
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        int i2=0,i3=0,i5=0;

        while (list.size()<index)
        {
            int m2=list.get(i2)*2;
            int m3=list.get(i3)*3;
            int m5=list.get(i5)*5;
            int min=Math.min(m2,Math.min(m3,m5));
            list.add(min);
            if (min==m2)i2++;
            if (min==m3)i3++;
            if (min==m5)i5++;
        }
        return list.get(list.size()-1);
    }

    public int GetUglyNumber_Solution1(int index) {
        if (index<=0)
            return 0;
        List<Integer> list=new ArrayList<Integer>();
        int count=0;
        for (int i=1;i<=Integer.MAX_VALUE;i++)
        {
            if (i==1) {
                list.add(i);
                ++count;
            }
            else {
                int temp=i;
                while (temp%2==0)
                {
                    temp/=2;
                }
                while (temp%5==0)
                {
                    temp/=5;
                }
                while (temp%3==0)
                {
                    temp/=3;
                }
                if (temp==1) {
                    list.add(i);
                    ++count;
                }
            }
            if (count==index)
                break;
        }
        return list.get(list.size()-1);
    }

    public static void main(String[] args) {
        long start= System.currentTimeMillis();
        //System.out.println(new Solution34().GetUglyNumber_Solution1(26));
        //new Solution34().GetUglyNumber_Solution1(9990);
        long end= System.currentTimeMillis();
        System.out.println("算法一:"+(end-start));
        long start1= System.currentTimeMillis();
        //System.out.println(new Solution34().GetUglyNumber_Solution(26));
        new Solution34().GetUglyNumber_Solution(999000);
        long end1= System.currentTimeMillis();
        System.out.println("算法二:"+(end1-start1));
    }
}
