package shujujiegou.day5;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/14
 * \* Time: 17:32
 */
//归并排序序曲
public class MergeApp {
    public static void merge(int[] arrA,int sizeA,int[] arrB,int sizeB,int[] arrC){
        int aDex=0,bDex=0,cDex=0;
        while (aDex<sizeA&&bDex<sizeB){
            if(arrA[aDex]<arrB[bDex]){
                arrC[cDex++]=arrA[aDex++];
            }
            else {
                arrC[cDex++]=arrB[bDex++];
            }
        }

        while (aDex<sizeA){
            arrC[cDex++]=arrA[aDex++];
        }
        while (bDex<sizeB){
            arrC[cDex++]=arrB[bDex++];
        }
    }

    public static void display(int[] arr){
        for (int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");

    }

    public static void main(String[] args) {
        int[] arrA={1,2,3,9};
        int[] arrB={0,4,5,6,7,8};
        int[] arrC=new int[10];

        merge(arrA,4,arrB,6,arrC);
        display(arrC);
    }
}
