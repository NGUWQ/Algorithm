package shujujiegou.day6;

import shujujiegou.day6.Array;

import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/20
 * \* Time: 9:45
 */
//快速排序 执行时间位O(N*logN)级
public class QuickSortApp {

    public static void main(String[] args) {

        int max=10;
        Array array=new Array(max);
//        for (int i=0;i<max;i++){
//            array.insert(new Random().nextInt(100));
//        }
        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.display();
        array.quickSort();
        array.display();
    }
}
