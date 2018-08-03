package utils;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/27
 * \* Time: 13:36
 */
public class ArraysMethod {

    public static void swap(int[] a,int out, int min) {
        int temp = a[out];
        a[out] = a[min];
        a[min] = temp;
    }
}
