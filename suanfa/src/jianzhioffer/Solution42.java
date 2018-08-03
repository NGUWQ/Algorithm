package jianzhioffer;

import java.util.ArrayList;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/13
 * \* Time: 14:08
 */
/*
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 *要求：
 * 输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * */
public class Solution42 {
    ArrayList<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<Integer> list2 = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum < 3)
            return alist;
        int i = 1;
            while (i <= sum)  {
                list = new ArrayList<Integer>();
                list2 = new ArrayList<Integer>();
                for (int j = i; j <= sum; j++) {
                    list.add(j);
                }
                int temp = sum;
                for (int j = 0; j < list.size(); j++) {
                    temp -= list.get(j);
                    if (temp == 0&&list.size()>1) {
                        for (int k = list.get(0); k <= list.get(j); k++) {
                            list2.add(k);
                        }
                        alist.add(list2);
                    }
                }
                i++;
            }
            return alist;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        for ( int n= (int) Math.sqrt(2*sum);n>=2;n--){
            if ((n&1)==1&&sum%n==0||(sum%n)*2==n){
                ArrayList<Integer> list=new ArrayList<Integer>();
                for (int j=0, k=sum/n-(n-1)/2;j<n;k++,j++){
                    list.add(k);
                }
                ans.add(list);
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        System.out.println(new Solution42().FindContinuousSequence2(1));
    }
}
