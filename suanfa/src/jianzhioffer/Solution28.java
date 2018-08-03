package jianzhioffer;

import java.util.*;


/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/5
 * \* Time: 13:47
 */
/*输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。*/
/* 思想：用递归的方式取出每个单词的子串,在此定义了一个set集合,不重复的单词排列,例如abc,
            1.一直递归,定位到最后两个单词的位置,并打印其所有的排列,
            2.然后调换倒数第三个字母的位置再重复1的操作,直到所有字母都调换完成并都递归完.
            最后用集合的排序方法将数组列表排序
*
* */
public class Solution28 {
    char[] array=new char[9];//创建一个用于存放单词的数组
    int size=0;
    ArrayList<String> arrayList=new ArrayList<String>();
    Set<String> set=new HashSet<String>();//创建一个set集合,因为set中不允许重复。即集合中所有的单词都是非重复的
    public ArrayList<String> Permutation(String str) {
        size=str.length();//获取字符串的长度
        for (int i=0;i<size;i++)
            array[i]=str.charAt(i);//将字符串存入数组中
        if (size==1)//只有一个字母时的情况
        {
            String s="";
            for(int j=0; j<size; j++)
                s+=array[j];
            set.add(s);
        }
        doAnagram(size);
        Iterator<String> iterator=set.iterator();//创建一个迭代器,迭代全排列的每一个单词,并添加到数组列表中
        while (iterator.hasNext())
        {
            arrayList.add(iterator.next());
        }
      Collections.sort(arrayList);//将数组列表排序
        return arrayList;
    }
    private void doAnagram(int newSize) {
        if (newSize==1) {
            return;
        }
        for (int i=0;i<newSize;i++){
            doAnagram(newSize-1);
            if (newSize==2)//定位到最右边的两个单词的位置
            {
                String s="";
                for(int j=0; j<size; j++)
                    s+=array[j];
                set.add(s);
            }
            rotate(newSize);//调换每个子字符串首字母的位置
        }
    }
    private void rotate(int newSize) {
        int j;
        int position=size-newSize;
        char temp=array[position];
        for (j=position+1;j<size;j++)
            array[j-1]=array[j];
        array[j-1]=temp;

    }

    public static void main(String[] args) {
        String str="abc";
        System.out.println(new Solution28().Permutation(str));
    }
}
