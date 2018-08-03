package shujujiegou.day6;

import shujujiegou.day6.Array;

import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/19
 * \* Time: 21:11
 */
//划分(排序) 运行O(N)时间
public class PartitionApp {
    public static void main(String[] args) {
        int max = 10;
        Array array = new Array(max);
        for (int i = 0; i < max; i++)
            array.insert(new Random().nextInt(100));
        array.display();
//        int index=array.apartition(0,max-1);
//        System.out.println("index is "+index);
//        array.display();
        int middle = array.getM();
        System.out.println(middle);
    }
}
