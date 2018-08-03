package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/21
 * \* Time: 12:33
 */
/*
* 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
* 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
* 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
*
* */
public class Solution53 {
    private int index=0;
    //参见剑指offer
    public boolean isNumeric(char[] str) {

        if (str.length<1)
            return false;
        boolean flag=scanInteger(str);
        if (index<str.length&&str[index]=='.')//判断是否有小数点
        {
            index++;
            flag=scanUnsignedInteger(str)||flag;//小数点后是否有数字
        }
        if (index<str.length&&(str[index]=='E'||str[index]=='e'))//是否含有指数
        {
            index++;
            flag=flag&&scanInteger(str);
        }
        return flag&&index==str.length;//是否将一整个字符串扫描完

    }

    private boolean scanInteger(char[] str)//检查是否有+,-号
    {

        if (index<str.length&&(str[index]=='+'||str[index]=='-'))
            index++;
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) //扫描数字
    {

        int start=index;
        while (index<str.length&&str[index]>='0'&&str[index]<='9')
            index++;
        return start<index;
    }


    //正则表达式
    public boolean isNumeric2(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?\\d*(\\.\\d*)?([eE][\\+-]?\\d+)?");
    }
    /*
以下对正则进行解释:
[\\+\\-]?            -> 正或负符号出现与否
\\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
(\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
                        否则一起不出现
([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
                        紧接着必须跟着整数；或者整个部分都不出现
\d 表示匹配的是数字
+ 表示重复一次或者多次
*  表示重复零次或者多次
*/

    public static void main(String[] args) {

        char[] str={'9','8','.','3'};
        System.out.println(new Solution53().isNumeric2(str));
    }

}
