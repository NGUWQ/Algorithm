package shujujiegou.day5;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/19
 * \* Time: 10:54
 */
//编程作业6.1(用加法实现乘法)递归
public class ChengFaApp {
    public static int result;

    public static int method(int x,int y){

        if (x==0||y==0)
            return 0;
        else {
            return (y+method(x-1,y));
        }
    }

    public static void main(String[] args) {

        int result=method(3,2);
        System.out.println(result);
    }
}
