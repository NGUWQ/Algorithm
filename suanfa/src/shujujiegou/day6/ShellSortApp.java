package shujujiegou.day6;

import shujujiegou.day6.Array;

import java.util.Random;
//希尔排序
public class ShellSortApp {
    public static void main(String[] args) {

        int max=100;
        Array array=new Array(max);
        for (int i=0;i<max;i++){
            array.insert(new Random().nextInt(1000));
        }
        array.shellSort();
        array.display();


    }
}
