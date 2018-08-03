package shujujiegou.day4;

import java.util.ArrayList;
import java.util.List;
/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/10
 * \* Time: 17:57
 */
//feibonaci数列
public class Febnacci {
    public static void feb(int n){
        List list=new ArrayList();
        int s1=1,s2=1,sum=1;
        for (int i=0;i<n;i++){
            if(i==0)
                sum=s1;
            else if(i==1)
                sum=s2;
            else {
                s1=s2;
                s2=sum;
                sum=s1+s2;
            }
            list.add(sum);
        }
        System.out.println(n+"的费波纳茨数列为:"+list);
    }
    public static void main(String[] args) {
        feb(10);

    }
}
