package shujujiegou.day5;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/16
 * \* Time: 9:43
 */
//归并排序(效率n*logn)
class DArray
{
    private int[] merge;
    private int items;

    public DArray(int max){
        merge=new int[max];
        items=0;
    }

    public void insert(int value){
        merge[items]=value;
        items++;
    }

    public void display(){
        for (int i=0;i<items;i++)
            System.out.print(merge[i]+" ");
        System.out.println();
    }

    public void mergeSort(){
        int[] workSpace=new int[items];
        recMergeSort(workSpace,0,items-1);

    }

    private void recMergeSort(int[] workSpace, int low, int up) {
        if (low==up)
            return;
        else {
            int mid=(low+up)/2;
            recMergeSort(workSpace,low,mid);
            recMergeSort(workSpace,mid+1,up);
            merges(workSpace,low,mid+1,up);
        }
    }

    private void merges(int[] workSpace, int low, int high, int up) {
        int j=0;
        int lows=low;
        int mid=high-1;
        int n=up-low+1;
        while (low<=mid&&high<=up){
            if (merge[low]<merge[high])
                workSpace[j++]=merge[low++];
            else
                workSpace[j++]=merge[high++];
        }

        while (low<=mid){
            workSpace[j++]=merge[low++];
        }

        while (high<=up){
            workSpace[j++]=merge[high++];
        }

        for (j=0;j<n;j++)
            merge[lows+j]=workSpace[j];

    }

}
public class MergeSortApp
{
    public static void main(String[] args) {
        int maxSize=20;
        DArray d=new DArray(maxSize);
        d.insert(4);
        d.insert(2);
        d.insert(3);
        d.insert(1);
        System.out.print("排序前:");
        d.display();
        System.out.print("排序后:");
        d.mergeSort();
        d.display();
    }
}