package shujujiegou.day6;

import shujujiegou.day6.Array;

import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/20
 * \* Time: 15:32
 */
//快速排序(三数据项取中划分)
public class QuickSortApp2 {

    public static void main(String[] args) {

        int max=12;
        Array array=new Array(max);
//        for (int i=0;i<max;i++){
//            array.insert(new Random().nextInt(100));
//        }
        array.insert(7);
        array.insert(6);
        array.insert(5);
        array.insert(4);
        array.insert(3);
        array.insert(2);
        array.insert(1);
        array.insert(0);
        array.display();
        array.quickSort2();
        array.display();
        System.out.println();
        System.out.println(array.getSum());
        System.out.println(array.getCount());
        System.out.println(array.getCounts());
    }
}
