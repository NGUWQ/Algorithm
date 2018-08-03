package shujujiegou.day6;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/19
 * \* Time: 16:05
 */
public class Array{
    private int[] array;
    private int items;
    private int count;//统计比较的次数
    private int counts;//统计复制的次数
    private int sum;//统计比较和复制总的次数

    public int getSum() {
        return count+counts;
    }

    public int getCount() {
        return count;
    }

    public int getCounts() {
        return counts;
    }

    public Array(int max){
        array=new int[max];
        items=0;
    }

    public int getItems() {
        return items;
    }

    public void insert(int value){
        array[items++]=value;
    }

    public void display(){
        System.out.println("数组为:");
        for (int i=0;i<items;i++) {
            System.out.print(array[i] + " ");
            if ((i+1)%10==0)
                System.out.println();
        }
    }

    //1.希尔排序
    public void shellSort(){
        /*
        * h:希尔排序增量
        * inter:内层所要比较的下标
        * outer:外层循环的下标
        */
        int inter,outer,h=1;
        while (h<items/3){
            h=h*3+1;
        }
        while (h>0){
            for (outer=h;outer<items;outer++){
                inter=outer;
                int temp=array[outer];
                while (inter>h-1&&array[inter-h]>temp){
                    array[inter]=array[inter-h];
                    inter-=h;
                }
                array[inter]=temp;
            }
            //比较这一层所有以h为增量的数组后  减小下一层的间隔增量
            h=(h-1)/3;
        }

    }

    //2.划分排序
    public int partition(int left,int right,int pivot){
        /*pivot:中间值，用来划分数组
        * left:数组起始位置
        * right:数组末端位置
        *
        * */
        int leftPr=left-1;
        int rightPr=right+1;
        while (true) {
            while (leftPr < right && array[++leftPr] < pivot)
                ;
            while (rightPr>left&&array[--rightPr]>pivot)
                ;
            if (leftPr>=rightPr)
                break;
            else
                swap(leftPr,rightPr);
        }
        return leftPr;
    }

    //2.编程作业7.1
    public int apartition(int left,int right){
        /*pivot:中间值，用来划分数组
         * left:数组起始位置
         * right:数组末端位置
         *
         * */
        int leftPr=left-1;
        int rightPr=right;
        int pivot=array[right];
        while (true) {
            while (leftPr<right&&array[++leftPr] < pivot)
                ;
            while (rightPr>left&&array[--rightPr]>pivot)
                ;
            if (leftPr>=rightPr)
                break;
            else
                swap(leftPr,rightPr);
        }
        swap(leftPr,right);
        return leftPr;
    }


    //3.快速排序
    public void quickSort(){
        recQuickSort(0,items-1);
    }

    private int partition1(int left,int right,int pivot){
        /*pivot:中间值，用来划分数组
         * left:数组起始位置
         * right:数组末端位置
         *
         * */
        int leftPr=left-1;
        int rightPr=right;
        while (true) {
            while (array[++leftPr]<pivot)//此处不判断leftPr是因为枢纽已经指向了最末端的位置，不会产生数组越界异常
                ;
            while (rightPr>0&&array[--rightPr]>pivot)//此处需要判断rightPr，防止数组下标越界
                ;
            if (leftPr>=rightPr)
                break;
            else
                swap(leftPr,rightPr);
        }
        swap(leftPr,right);//执行到此条语句时说明已经找到了枢纽位置，只需将数组原来最右端的枢纽位置和此枢纽位置呼唤即可
        return leftPr;//返回枢纽位置
    }

    private void recQuickSort(int left,int right){

        if (right-left<=0)//当数组中项的个数只有1个或没有时,不用排序就直接返回
            return;
        else {
            int pivot=array[right];//获得所要划分数组最右边得到数据项位枢纽
            int p=partition1(left,right,pivot);//获得进行划分排序后枢纽的位置，此时枢纽的位置已经确定，无需排序
            recQuickSort(left,p-1);//不断递归调用枢纽左边的数组
            recQuickSort(p+1,right);//不断递归调用枢纽右边的数组
        }

    }

    //4.快速排序(三数据项取中划分)
    private int mediaOf3(int left,int right){
        int center=(left+right)/2;
        if (array[left]>array[center])
            swap(left,center);
        if (array[left]>array[right])
            swap(left,right);
        if (array[center]>array[right])
            swap(center,right);
        swap(center,right-1);
        return array[right-1];
    }

    private void manualSort2(int left,int right){
        int size=right-left+1;
        if (size<=1)
            return;
        if (size==2){
            if (array[left]>array[right])
                swap(left,right);
            return;
        }
        else{
            if (array[left]>array[right-1])
                swap(left,right-1);
            if (array[left]>array[right])
                swap(left,right);
            if (array[right-1]>array[right])
                swap(right-1,right);
        }
    }

    public void quickSort2()//编程作业7.2
    {
        recQuickSort2(0,items-1);
    }

    private void recQuickSort2(int left,int right){
        int size=right-left+1;
        if (size<=3)
            manualSort2(left,right);
        else {
            int pivot=mediaOf3(left,right);
            int p=partition2(left,right,pivot);
            recQuickSort2(left,p-1);
            recQuickSort2(p+1,right);
        }

    }

    public int partition2(int left,int right,int pivot)//编程作业7.2
    {
        int leftPr=left;
        int rightPr=right-1;
        while (true) {
            count++;
            while (array[++leftPr] < pivot)
            {
                count++;
            }
            count++;
            while (array[--rightPr]>pivot)
            {
                count++;
            }
            if (leftPr>=rightPr)
                break;
            else {
                swap(leftPr, rightPr);
                counts+=3;
            }
        }
        swap(leftPr,right-1);
        counts+=3;
        return leftPr;
    }

    //4.快速排序(小划分,界限位10,小于10的子数组用插入排序)3的升级版
    public void quickSort3(){
        recQuickSort3(0,items-1);
        //5.insertSort(0,items-1);另一种方法 先不处理小于界限值的排序，等到所有数据快速排序后再使用插入排序
    }

    private void recQuickSort3(int left,int right) {

        int size=right-left+1;
        if (size<10)
            insertSort(left,right);
            //5.return;
        else {
            int pivot=mediaOf3(left,right);
            int p=partition2(left,right,pivot);
            recQuickSort3(left,p-1);
            recQuickSort3(p+1,right);
        }

    }

    public void insertSort(int left,int right) {
        int out,in;
        for (out=left+1;out<=right;out++){
            int temp=array[out];
            in=out;
            while (in>0&&array[in-1]>temp){
                array[in]=array[in-1];
                --in;
            }
            array[in]=temp;
        }
    }

    //编程作业7.3
    public int getMiddle(int left,int right){
        int leftPr=left-1;
        int rightPr=right;
        int pivot=array[right];
        while (true){
            while (leftPr<right&&array[++leftPr]<pivot)
                ;
            while (rightPr>left&&array[--rightPr]>pivot)
                ;
            if (leftPr>=rightPr)
                break;
            else {
                swap(leftPr,rightPr);
            }
        }
        swap(leftPr,right);
        int media=array.length/2;
        if (leftPr==media)
            return leftPr;
        else if (leftPr>media)
            return getMiddle(left,leftPr-1);
        else
            return getMiddle(leftPr+1,right);
    }

    public int getM(){
        return array[getMiddle(0,items-1)];
    }

    private void swap(int left, int right) {
        int temp=array[left];
        array[left]=array[right];
        array[right]=temp;
    }
}
