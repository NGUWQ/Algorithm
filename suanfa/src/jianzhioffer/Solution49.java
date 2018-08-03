package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/19
 * \* Time: 20:22
 */
/*
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * */
public class Solution49 {
    public int StrToInt(String str) {
        boolean flag = false;
//判断输入是否合法
        if (str == null || str.trim().equals("")) {
            flag = true;
            return 0;
        }
// symbol=0,说明该数为正数;symbol=1，该数为负数;start用来区分第一位是否为符号位
        int symbol = 0;
        int start = 0;
        char[] chars = str.trim().toCharArray();
        if (chars[0] == '+') {
            start = 1;
        } else if (chars[0] == '-') {
            start = 1;
            symbol = 1;
        }
        int result = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                flag = true;
                return 0;
            }
            int sum = result * 10 + (int) (chars[i] - '0');


            if ((sum - (int) (chars[i] - '0')) / 10 != result) {
                flag = true;
                return 0;
            }

            result = result * 10 + (int) (chars[i] - '0');
            /*
             * 本人认为java热门第一判断是否溢出是错误的，举个反例
             * 当输入为value=2147483648时，在计算机内部的表示应该是-2147483648
             * 显然value>Integer.MAX_VALUE是不成立的
            */
        }
        // 注意：java中-1的n次方不能用：(-1)^n .'^'异或运算
        // 注意，当value=-2147483648时，value=-value
        result = (int) Math.pow(-1, symbol) * result;
        return result;


    }

    public static int StrToInt1(String s,int radix)throws NumberFormatException {
        if (s == null) {
            throw new NumberFormatException("null");
        }

        if (radix < Character.MIN_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " greater than Character.MAX_RADIX");
        }

        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    //throw NumberFormatException.forInputString(s);
                    throw new NumberFormatException(s);

                if (len == 1) // Cannot have lone "+" or "-"
                    //throw NumberFormatException.forInputString(s);
                    throw new NumberFormatException(s);
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++),radix);
                if (digit < 0) {
                    //throw NumberFormatException.forInputString(s);
                    throw new NumberFormatException(s);
                }
                if (result < multmin) {
                    //throw NumberFormatException.forInputString(s);
                    throw new NumberFormatException(s);
                }
                result *= radix;
                if (result < limit + digit) {
                    //throw NumberFormatException.forInputString(s);
                    throw new NumberFormatException(s);
                }
                result -= digit;
            }
        } else {
            //throw NumberFormatException.forInputString(s);
            throw new NumberFormatException(s);
        }
        return negative ? result : -result;
    }

    public int StrToInt1(String str){
        if (str.length()==0||str.trim().equals(""))
            return 0;
        int supers=-Integer.MAX_VALUE;//上临界值
        int result=0;
        int start=0;//记录第一位是否是符号位
        boolean flag=false;//记录符号位
        char[] chars=str.toCharArray();
        if (chars[0]=='+') {
            start = 1;
        }
        else if (chars[0]=='-') {
            start = 1;
            flag=true;
            supers=Integer.MIN_VALUE;//下临界值
        }
        int multmin=supers/10;//int型数据前9位的临界值
        for (int i=start;i<chars.length;i++){
            if (chars[i]<'0'||chars[i]>'9')
                return 0;
            if (result<multmin)//防止前9位过大以致溢出
                throw new RuntimeException("no");
            result=result*10;
            if (result<supers+(int)(chars[i]-'0'))//判断总体的值是否溢出
                throw new RuntimeException("no");
            result-=(int)(chars[i]-'0');
        }
        return flag?result:-result;
    }
    public static void main(String[] args) {
        //int v=2147483648;

        System.out.println(new Solution49().StrToInt1("5147483647"));

    }
}
