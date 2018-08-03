package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/14
 * \* Time: 12:02
 */
/*
汇编语言中有一种移位指令叫做循环左移（ROL），
现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,
要求输出循环左移3位后的结果，即“XYZdefabc”。
是不是很简单？OK，搞定它！
* */
public class Solution44 {

    //法1
    public String LeftRotateString(String str,int n) {
        if (str.length()==0||str==""||n==0)
            return str;
        String s="";
        for (int i=n;i<str.length();i++)
        {
            s+=str.charAt(i);
        }
        for (int i=0;i<n;i++){
            s+=str.charAt(i);
        }
        return s;
    }

    //法2
    public String LeftRotateString2(String str,int n) {
        if (str.length()==0||str==""||n==0)
            return str;
        n%=str.length();
        str=reverse(str,0,n-1);
        str=reverse(str,n,str.length()-1);
        str=reverse(str,0,str.length()-1);
        return str;
    }

    private String reverse(String str, int low, int high) {

        char[] chars=str.toCharArray();
        while (low<high){
            char temp=chars[high];
            chars[high]=chars[low];
            chars[low]=temp;
            low++;
            high--;
        }
        StringBuilder s=new StringBuilder();
        for (char c:chars)
            s.append(c);
        return s.toString();
    }


    //法3
    public String LeftRotateString3(String str,int n) {
        if (str.length()==0||str==""||n==0)
            return str;
        StringBuilder strs=new StringBuilder(str);
        n%=str.length();
        strs.append(strs.substring(0,n));
        return strs.substring(n,strs.length()).toString();
    }

    //法4
    public String LeftRotateString4(String str,int n) {
        if (str.length()==0||str==""||n==0)
            return str;
        n%=str.length();
        str+=str;
        return str.substring(n,(str.length()/2)+n);
    }

    public static void main(String[] args) {

        String s="abcXYZdef";
        String[] split = s.split(" ");
        //System.out.println(new Solution44().LeftRotateString4(s,0));
        System.out.println(split[0]);
    }
}
