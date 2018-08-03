package jianzhioffer;

import java.util.Stack;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/15
 * \* Time: 8:21
 */
/*牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
但却读不懂它的意思。例如，“student. a am I”。
后来才意识到，这家伙原来把句子单词的顺序翻转了，
正确的句子应该是“I am a student.”。
Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？*/
public class Solution45 {
    public String ReverseSentence(String str) {
        if(str == null){ return null;}
        if(str.trim().equals("")){
            return str;
        }
        String[] string=str.split(" ");
        str=reverse(string,0,string.length-1);
        return str;
    }
    private String reverse(String[] string, int low, int up) {
        while (low<up){
            String temp=string[low];
            string[low]=string[up];
            string[up]=temp;
            low++;
            up--;
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i< string.length;i++)
        {
            if (i==string.length-1)
                sb.append(string[i]);
            else {
                sb.append(string[i]+" ");
            }
        }
        return sb.toString();
    }

    //两次反转:
    //先反转句子,再反转每一个单词
    public String ReverseSentence2(String str) {
        if (str.length()==0||str==null||str.trim().equals(""))
            return str;
        char[] c=str.toCharArray();
        reverse(c,0,str.length()-1);//反转整个句子
        //反转每个单词
        int begin=0;
        int end=0;
        while (begin!=c.length){
            if (c[begin]==' ')//开始为空格
            {
                begin++;//begin和end都自增
                end++;
            }
            else if (c[end]==' ')//遍历到终止字符为空格就进行反转
            {
                reverse(c,begin,--end);
                begin=++end;
            }
            else if (end==c.length-1)//遍历到末尾就进行反转
            {
                reverse(c,begin,end);
                begin=++end;
            }
            else {
                end++;//没有到末尾就自增
            }
        }
        return String.valueOf(c);
    }
    private void reverse(char[] c, int low, int up) {
        while (low < up) {
            char temp = c[low];
            c[low] = c[up];
            c[up] = temp;
            low++;
            up--;
        }
    }

    //法3,待优化
    public String ReverseSentence3(String str) {
        if (str.length()==0||str==null||str.trim().equals(""))
            return str;
        Stack<String> stack=new Stack();
        //String string=str.trim();
        String string;
        String[] strings=str.split(" ");
        for (int i=0;i<strings.length;i++){
            stack.push(strings[i]);
        }
        string=stack.pop();
        while (!stack.isEmpty()){
            string+=" "+stack.pop();
        }
        return string;
    }

    public static void main(String[] args) {


        String string="  I  love   you j   ";
        String[] strings=string.split(" ");
        System.out.println(strings[0]+strings[1]+strings[2]);
        //System.out.println(new Solution45().ReverseSentence3(string));
    }
}
