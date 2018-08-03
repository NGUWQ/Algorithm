package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/10
 * \* Time: 18:33
 */
/*
* 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
* 输入一个数组,求出这个数组中的逆序对的总数P。
* 并将P对1000000007取模的结果输出。
* 即输出P%1000000007*/

/*思想：使用归并排序,将数组不断切割,然后重新排序,如果排序过程中存在前面的元素大于后面的元素,
就存在逆序对,并记录因为合并的子数组分别是有序的,即如果发现一位置的元素比所比较一位置的元素大,
那么逆序对的个数就是后面位置减前面位置。*/
public class Solution36 {
    private final int N = 1000000007;
    int[] help;//help数组用于暂时存储排序后数组的值

    public int InversePairs(int[] array) {
        if (array.length==0||array==null)
            return -1;

        help = new int[array.length];
        return mergeSort(array, 0, array.length - 1)%N;//返回的结果还要取模,防止过大.

    }

    private int mergeSort(int[] array, int low, int up) {
        if (low == up)//元素本身不存在逆序对
            return 0;
        else {
            int mid = (low + up) / 2;//获得每一个子数组的中间位置
            return mergeSort(array, low, mid)%N+
            mergeSort(array, mid + 1, up)%N+
            merges(array, low, mid + 1, up)%N;
        }

    }

    private int merges(int[] array, int low, int high, int up) //high：合并后的数组的中间坐标右边的第一个位置
    {
        int count=0;//记录逆序对出现的次数
        int j = 0;
        int lows = low;//记录起始位置
        int mid = high - 1;//数组的中间位置
        int n = up - low + 1;//子数组的元素个数
        while (low <= mid && high <= up) {
            if (array[low] < array[high])
                help[j++] = array[low++];
            else {
                help[j++] = array[high++];
                count+=mid-low+1;
                if (count>N)
                    count%=N;
            }
        }
        while (low<=mid)//前一部分数组还有多余元素
            help[j++]=array[low++];
        while (high<=up)//后一部分数组还有多余元素
            help[j++]=array[high++];
        for (j=0;j<n;j++)//将临时数组中排序好的元素放回原数组中
            array[lows+j]=help[j];
        return count;
    }

    public static void main(String[] args) {

        int[] array={1,2,7,0};
        System.out.println(new Solution36().InversePairs(array));
    }
}
