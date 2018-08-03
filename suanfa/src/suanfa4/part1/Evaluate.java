package suanfa4.part1;

import java.util.Stack;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/26
 * \* Time: 19:09
 */
//双栈算术表达式求值法
public class Evaluate {

    public Double solution(String s){
        Stack<String> ops=new Stack<>();
        Stack<Double> val=new Stack<>();
        if (s.length()==0||s==null)
            return 0.0;
        int i=-1;
        String[] strings=s.split(" ");
        while (++i<strings.length){
            if (strings[i].equals("("))
                continue;
            else if (strings[i].equals("+")) ops.push(strings[i]);
            else if (strings[i].equals("-"))ops.push(strings[i]);
            else if (strings[i].equals("*"))ops.push(strings[i]);
            else if (strings[i].equals("/"))ops.push(strings[i]);
            else if (strings[i].equals("sqrt"))ops.push(strings[i]);
            else if (strings[i].equals(")")){
                String op=ops.pop();
                Double v=val.pop();
                if (op.equals("+")) v=v+val.pop();
                else if (op.equals("-")) v=v-val.pop();
                else if (op.equals("*")) v=v*val.pop();
                else if (op.equals("/")) v=v/val.pop();
                else if (op.equals("sqrt")) v=Math.sqrt(v);
                val.push(v);
            }
            else
                val.push(Double.parseDouble(strings[i]));
        }
        return val.pop();
    }
    public static void main(String[] args) {

        String s="( 100 + ( 2 * 7 ) * 4 ) )";
        System.out.println(new Evaluate().solution(s));


    }
}
