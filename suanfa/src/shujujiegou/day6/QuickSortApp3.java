package shujujiegou.day6;

import shujujiegou.day6.Array;

import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/20
 * \* Time: 16:57
 */
//快速排序(小划分,界限位10,小于10的子数组用插入排序)
public class QuickSortApp3 {
    public static void main(String[] args) {
        int max=20;
        Array array=new Array(max);
        for (int i=0;i<max;i++){
            array.insert(new Random().nextInt(100));
        }
        array.display();
        array.quickSort3();
        array.display();
    }
}
