package jianzhioffer;
import java.util.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/7
 * \* Time: 0:26
 */
/*输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
* */
public class Solution33 {
    List<Long> list=new ArrayList<Long>();
    int size;
    int[] array;

    public String PrintMinNumber(int [] numbers) {
        size=numbers.length;
        array=numbers;
        if (numbers.length==0)
            return "";
        else if (numbers.length==1)
            return String.valueOf(numbers[0]);
        else {
            method(size);
            long temp=list.get(0);
            for (int i=1;i<list.size();i++)
                if (temp>list.get(i))
                    temp=list.get(i);
            return String.valueOf(temp);
        }

    }

    private void method(int newSize) {
        if (newSize==1)
            return;
        else {
            for (int i=0;i<newSize;i++)
            {
                method(newSize-1);
                if (newSize==2)
                {
                    String s="";
                    for (int j=0;j<size;j++){
                        s+=array[j];
                    }
                    list.add(Long.parseLong(s));
                }
                rotate(newSize);
            }
        }
    }

    private void rotate(int newSize) {
        int j;
        int position=size-newSize;
        int temp=array[position];
        for (j=position+1;j<size;j++)
            array[j-1]=array[j];
        array[j-1]=temp;
    }

    public static void main(String[] args) {
        int[] array={};
        System.out.println(new Solution33().PrintMinNumber(array));
    }
}
