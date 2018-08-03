package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/26
 * \* Time: 19:56
 */

/*
* 请实现一个函数，将一个字符串中的空格替换成“%20”。
* 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
* */
public class Solution3 {
    public static String replaceSpace(StringBuffer str) {
        String s="";
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if (c==' ') {
                str.replace(i, i+1, "%20");
                c=str.charAt(i);
            }
                s+=c;
        }
        return s;
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer=new StringBuffer("we are happy");
        String string=replaceSpace(stringBuffer);
        System.out.println(string);
    }
}