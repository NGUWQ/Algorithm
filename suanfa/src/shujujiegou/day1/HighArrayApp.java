package shujujiegou.day1;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/2
 * \* Time: 19:31
 */
class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] == searchKey)
                break;
        if (j == nElems)
            return false;
        else
            return true;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (value == a[j])
                break;
        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");

        }
        System.out.println();
    }

    public long getMax() //输出数组最大值的下标，为空时返回-1
    {
        //int count = 0;
        long max=-1;
        max = a[0];
        for (int j = 0; j < nElems; j++) {
            if (max < a[j]) {
                max = a[j];
                //count = j;
            }
        }
        return  max;
    }

    /*public void removeMax()//输出数组最大值的下标,并删除最大值
    {
        int j, count = 0;
        long max;
        max = a[0];
        for (j = 0; j < nElems; j++) {
            if (max < a[j]) {
                max = a[j];
                count = j;
            }
        }
        if (a[count] == 0 && a.length == 0)//如果a[count]为0且数组长度为0的话，数组为空
            count = -1;
        System.out.println("max index is " + count);
        for (int k = count; k < nElems; k++) {
            a[k] = a[k + 1];
            nElems--;
        }
    }

    public void removeMax()//输出数组最大值的下标,并删除最大值
    {
        int j, count = 0;
        long max;
        long[] b=new long[nElems];
        max = a[0];
        for (j = 0; j < nElems; j++) {
            b[j]=a[j];
            if (max < a[j]) {
                max = a[j];
                count = j;
            }
        }
        for (int t=0; t<b.length;t++) {
//            for(int o=t;o<b.length;o++){
//                if(b[t]<b[o]){
//                    max=b[t];
//                    b[t]=b[o];
//                    b[o]=max;
//                }
//            }
            System.out.print(b[t]+" ");
        }
        System.out.println();
        if (a[count] == 0 && a.length == 0)//如果a[count]为0且数组长度为0的话，数组为空
            count = -1;
        System.out.println("max index is " + count);
//        for (int k = count; k < nElems; k++) {
//            a[k] = a[k + 1];
//            nElems--;
//        }
        }
        */
    public long removeMax(){
        long max = -1;
        int index = -1;
        for(int j = 0;j <nElems;j++){
            if(a[j] > max){
                max = a[j];
                index = j;
            }
        }
        if(index != -1){
            for(int i = index;i< nElems;i++){
                a[i] = a[i+1];
            }
            nElems--;
        }
        return max;
    }

    //编程作业2.6 方法1
    public void noDup(){
        int NULL=-1;//用-1做特殊值
        for(int i=0;i<nElems;i++){
            for(int j=i+1;j<nElems;j++){
                if(a[i]!=NULL&&a[i]==a[j]){
                    a[i]=NULL;
                }
            }
        }
        for(int i=0;i<nElems;){
            if(a[i]==NULL){
                for(int j=i;j<nElems;j++){
                    a[j]=a[j+1];
                }
                nElems--;//缩小数组的大小
            }
            else {
                i++;
            }
        }

    }

    //编程作业2.6 方法2
    public void noDup1(){
        int NULL=-1;
        for(int i=0;i<nElems;i++){
            for(int j=i+1;j<nElems;j++){
                if(a[i]!=NULL&&a[i]==a[j]){
                    a[i]=NULL;
                }
            }
        }
        int order=0;
        for(int temp=0;temp<nElems;temp++){
            if(a[temp]!=NULL){
                if(temp>order){
                    a[order]=a[temp];
                }
                order++;
            }
        }
        nElems=order;//缩小数组的大小
    }
}

    public class HighArrayApp {
        public static void main(String[] args) {
            int maxSize = 100;
            HighArray arr;
            arr = new HighArray(maxSize);
            arr.insert(22);
            arr.insert(11);
            arr.insert(33);
            arr.insert(1);
            arr.insert(66);
            arr.insert(22);
            arr.insert(11);
            arr.insert(33);
            arr.display();
            //==========================================================================================
            //编程作业2.1
            //long max = arr.getMax();
            //System.out.println("Found max is "+max);

            //================================================================================
            //编程作业2.2
            //arr.removeMax();
            //arr.display();

            //================================================================================
            //编程作业2.3
//            HighArray sortedArr = new HighArray(maxSize);
//            max = arr.removeMax();
//            while(max!=-1){
//                sortedArr.insert(max);
//                max = arr.removeMax();
//            }
//            System.out.println("逆序排列");
//            sortedArr.display();

            //编程作业2.6
            arr.noDup1();
            arr.display();


        }
    }
