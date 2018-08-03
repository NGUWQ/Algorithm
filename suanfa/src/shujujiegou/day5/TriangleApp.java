package shujujiegou.day5;

import java.util.Scanner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/13
 * \* Time: 19:08
 */
//计算三角数字的和以及阶乘(递归) 第n个的三角数字为(n*n+n)/2 用来校验
public class TriangleApp {
    public static int triangle(int n){
        if (n==1)
            return 1;
        else
            return (n+triangle(n-1));
    }
    public static int factorial(int n){
        if (n==0)
            return 1;
        else
            return (n*factorial(n-1));
    }
    public static void main(String[] args) {
        System.out.println("此程序用来解决三角数字和以及阶乘");
        while (true) {
            System.out.println("请输入一个数字,按e或E停止！");
            Scanner scanner = new Scanner(System.in);
            String s=scanner.nextLine();
            if(s.equalsIgnoreCase("e"))
                break;
            int data = Integer.parseInt(s);
            int sum = triangle(data);
            long sums=factorial(data);
            System.out.println("所求的三角列数和阶乘为:" + sum+"  "+sums);
        }
    }
}
