package shujujiegou.day3;

import shujujiegou.day3.StackX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/5
 * \* Time: 16:52
 */
//栈:分隔符匹配
class BrackerChecker{
    private String input;

    public BrackerChecker(String in){
        input=in;
    }

    public void check(){

        int stackSize=input.length();
       StackX stack=new StackX(stackSize);
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            switch (ch){
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if(!stack.isEmpty()){
                        int chs= (int) stack.pop();
                        chs=(char)chs;
                        if((ch=='}'&&chs!='{')|| (ch==']'&&chs!='[')
                            ||(ch==')'&&chs!='(')){
                            System.out.println("Error: "+ch+" at "+i);

                        }
                    }
                    else
                        System.out.println("Error: "+ch+" at "+i);
                    break;
                default:
                    break;
            }
        }
        if(!stack.isEmpty()){
            System.out.println("Error: missing right delimiter");
        }
    }
}
public class BracketsApp {

    public static void main(String[] args) {

        String input,output;
        while (true){
            System.out.println("Enter  String containing delimiter:");
            System.out.flush();//控制台刷新
            try {
                input=getString();//获取从控制台输入的字符串
                if(input.equals(""))//如果用户没有输入任何字符串，就退出
                    break;
                BrackerChecker bc=new BrackerChecker(input);
                bc.check();
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
