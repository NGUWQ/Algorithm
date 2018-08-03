package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/11
 * \* Time: 12:51
 */
/*统计一个数字在排序数组中出现的次数。
思路:使用二分查找,找到k第一次和最后一次出现的位置相减加1即可.
 * */
public class Solution38 {
    int count = 0;

    public int GetNumberOfK1(int[] array, int k) {
        //int count=0;
        if (array.length == 0 || array == null)
            return count;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k)
                count++;
            if (array[i] > k)
                break;
        }
        return count;

    }

    public int GetNumberOfK2(int[] array, int k) {
        if (array.length == 0 )
            return 0;
        if (array[0]<=array[array.length-1])//数组为升序
        {
            int firstK = binaryFirst(array, 0, array.length - 1, k);
            int lastK = binaryLast(array, 0, array.length - 1, k);
            if (firstK != -1 && lastK != -1)
                return lastK - firstK + 1;
        }
        else if (array[0]>array[array.length-1])//数组为降序
        {
            int firstK = rbinaryFirst(array, 0, array.length - 1, k);
            int lastK = rbinaryLast(array, 0, array.length - 1, k);
            if (firstK != -1 && lastK != -1)
                return lastK - firstK + 1;
        }
//        else
//            return array.length;
        return 0;
    }

    private int binaryFirst(int[] array, int low, int up, int k) {
        if (low > up)
            return -1;
        int mid = (low + up) >> 1;
        if (array[mid] < k)
            return binaryFirst(array, mid+1, up, k);
        else if (array[mid] > k)
            return binaryFirst(array, low, mid-1, k);
        else if (mid - 1 >=low && array[mid - 1] == k)
            return binaryFirst(array, low, mid - 1, k);
        else {
            return mid;
        }
    }

    private int binaryLast(int[] array, int low, int up, int k) {
        while (low <= up) {
            int mid = (low + up) >> 1;
            if (array[mid] > k)
                up = mid - 1;
            else if (array[mid] < k)
                low = mid + 1;
            else if (mid + 1 <=up&& array[mid + 1] == k)
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public int rbinaryFirst(int[] array,int low,int up,int k){
        if (low>up)
            return -1;
        int mid=(low+up)>>1;
        if (array[mid]>k)
            return rbinaryFirst(array,mid+1,up,k);
        else if (array[mid]<k)
            return rbinaryFirst(array,low,mid-1,k);
        else if (mid-1>=low&&array[mid-1]==k)
            return rbinaryFirst(array,low,mid-1,k);
        else
            return mid;
    }

    public int rbinaryLast(int [] array,int low,int up,int k){
        while (low<=up){
            int mid=(low+up)>>1;
            if (array[mid]>k)
                low=mid+1;
            else if (array[mid]<k)
                up=mid-1;
            else if (mid+1<=up&&array[mid+1]==k)
                low=mid+1;
            else
                return mid;
        }
        return -1;
    }

    public int GetNumberOfK3(int[] array, int k) {
        return binarySearchs2(array, k + 0.5) - binarySearchs2(array, k - 0.5);
    }

    private int binarySearchs2(int[] array, double num) {
        int l = 0;
        int u = array.length - 1;
        while (l <= u) {
            int mid = (u - l) / 2 + l;
            if (array[mid] < num)
                l = mid + 1;
            else if (array[mid] > num)
                u = mid - 1;
        }
        return l;
    }

    public static void main(String[] args) {

        int[] array = {9,9,9,9};
        System.out.println(new Solution38().GetNumberOfK2(array, 7));
    }
}
