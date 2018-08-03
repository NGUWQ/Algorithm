package suanfa4.part2;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/27
 * \* Time: 11:02
 */
public class SelectionSort {

    //选择排序 O(n^2)
    public void sort(int[] array){
        for (int i=0;i<array.length;i++){
            int min=i;
            for (int j=i+1;j<array.length;j++){
                if (array[j]<array[min])
                    min=j;
            }
            //swap(array,i,min);
        }
    }


}
