package shujujiegou.day3;

import shujujiegou.day3.StackX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/5
 * \* Time: 15:31
 */
//栈实现简单的字母反序
class Reverser//将反序的方法都封装在此类中
{
    private String input;//接收输入的字符串
    private String output;//输出反序后的字符串

    public Reverser(String in){
        input=in;
    }

    public String doRev()//反序方法
    {
        int asize=input.length();
       StackX stack=new StackX(asize);

        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            stack.push(ch);
        }
        output="";
        while (!stack.isEmpty()){
            int ch= (int) stack.pop();//这里为了方便使用了StackApp.java中的Stack类，从而要进行必要的强制转换
            output+=(char)ch;
        }
        return output;
    }

}
public class ReverseApp {

    public static void main(String[] args) {
        String input,output;
        while (true){
            System.out.println("Enter a String:");
            System.out.flush();//控制台刷新
            try {
                input=getString();//获取从控制台输入的字符串
                if(input.equals(""))//如果用户没有输入任何字符串，就退出
                    break;
                Reverser reverser=new Reverser(input);
                output=reverser.doRev();
                System.out.println("reverse: "+output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static String getString() throws IOException {
        //Scanner scanner=new Scanner(System.in);
        //String s=scanner.nextLine();//第二种接收控制台的字符串的方法
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader buf=new BufferedReader(in);//将控制台的内容放进一个缓冲区
        String s=buf.readLine();
        return s;
    }
}
