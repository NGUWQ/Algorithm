package shujujiegou.day2;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/4
 * \* Time: 0:15
 */
//插入排序
class InsertSort{
    private long[] a;
    private int nElems;

    public InsertSort(int max) {
        a=new long[max];
        nElems=0;
    }

    public void insert(long value){
        a[nElems]=value;
        nElems++;
    }

    public void display(){
        for(int i=0;i<nElems;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public void insertSort(){
        int out,in;
        /*for(out=1;out<nElems;out++){
            long temp=a[out];
            in=out;
            while(in>0&&a[in-1]>=temp){
                a[in]=a[in-1];
                --in;
            }
            a[in]=temp;
        }*/
        for (out=1;out<nElems;out++){
            for (in=out;in>0&&a[in]<a[in-1];in--)
                swap(in,in-1);
        }
    }
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }


    //编程作业3.5
    public void insertSort1(){
        int out,in;
        int conpare=0;//比较次数
        int copy=0;//复制次数(移动次数)
        for(out=1;out<nElems;out++){
            long temp=a[out];
            in=out;
            while(in>0){
                if(a[in-1]>=temp) {
                    a[in] = a[in - 1];
                    --in;
                    conpare++;
                    copy++;
                }
                else {
                    conpare++;
                    break;
                }
            }
            a[in]=temp;
        }
        System.out.println("compare: "+conpare+" cpoy: "+copy);
    }

    //编程作业3.6
    public void insertSort2(){
        int out,in,count=0;
        long flag=Long.MIN_VALUE;//标志值,数组中的值不可能为此值
        for(out=1;out<nElems;out++){
            long temp=a[out];
            in=out;
            while(in>0&&a[in-1]>=temp&&a[in-1]!=flag) {
                if(a[in-1]==temp)
                {
                    temp=Long.MIN_VALUE;
                    count++;
                }
                    a[in] = a[in - 1];
                    --in;
                }
                a[in]=temp;
            }
            nElems-=count;
        for(int i=0;i<nElems;i++){
            a[i]=a[i+count];
        }

        }

    //编程作业3.2
    public long media(){
        this.insertSort();
        return a[nElems/2];
    }

    //编程作业3.3
    public void noDup(){
        this.insertSort();
        long Flag=Long.MIN_VALUE;
        int count=0;
        for(int i=0;i<nElems;i++)
        {
            for(int j=i+1;j<nElems;j++){
                if(a[i]==a[j]) {
                    a[i] = Flag;
                    count++;
                }
            }
        }
        int firsthole=-1;
        for(int i=0;i<nElems;i++){
            if(a[i]==Flag && firsthole==-1){
                firsthole=i;
            }
            else if (a[i]!=Flag && firsthole!=-1){
                a[firsthole++]=a[i];
            }
        }
        nElems-=count;
    }
    public int size(){
        return nElems;
    }
}
public class InsertSortApp {

    public static void main(String[] args) {
        int maxSize=100;
        InsertSort arr=new InsertSort(maxSize);
        arr.insert(22);
        arr.insert(33);
        arr.insert(44);
        arr.insert(55);
        arr.insert(66);
        arr.insert(99);
        arr.insert(88);
        arr.insert(8);
        arr.insert(88);
        arr.insert(8);
        arr.insert(67);
//        arr.insert(45);

//        arr.insert(11);
//        arr.insert(10);
//        arr.insert(9);
//        arr.insert(8);
//        arr.insert(7);
//        arr.insert(6);
//        arr.insert(5);
//        arr.insert(4);
//        arr.insert(3);
//        arr.insert(2);

        //arr.display();
        arr.insertSort();
        arr.display();
        //arr.insertSort2();
        //arr.display();


    }
}
