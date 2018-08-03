package suanfa4.part2;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/27
 * \* Time: 19:28
 */
//归并排序,O(nlgn),需要额外空间
public class MergeSort {
    int[] help;
    int[] array={2,1,3,5,6,4};

    public void sort(){
        help=new int[array.length];
        helper(array,0,array.length-1);
        for (int i:array)
            System.out.print(i+" ");
    }

    private void helper(int[] array, int lo, int hi) {
        if (hi<=lo) return;
        int mid=(lo+hi)/2;
        helper(array,lo,mid);
        helper(array,mid+1,hi);
        merge(array,lo,mid,hi);
    }

    private void merge(int[] array, int lo, int mid, int hi) {
        int i=lo,j=mid+1;
        for (int k=lo;k<=hi;k++)
            help[k]=array[k];
        for (int k=lo;k<=hi;k++){
            if (i>mid)array[k]=help[j++];
            else if (j>hi)array[k]=help[i++];
            else if (help[j]<help[i])array[k]=help[j++];
            else array[k]=help[i++];
        }
    }

    public static void main(String[] args) {


        //array=new MergeSort().sort(array);
        MergeSort s=new MergeSort();
        s.sort();
    }
}
