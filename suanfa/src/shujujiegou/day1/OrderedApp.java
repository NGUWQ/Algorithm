package shujujiegou.day1;
//二分查找
class OrdArray{
    private long[] a;
    private int nElems;

    public OrdArray(int max) {
        a=new long[max];
        nElems=0;
    }
    public int size(){
        return nElems;
    }
    public int find(long searchKey){
        int lowerBound=0;
        int upperBound=nElems-1;
        int curIn;
        while (true){
            curIn=(lowerBound+upperBound)/2;
            if(a[curIn]==searchKey)
                return curIn;
            else if (lowerBound>upperBound)
                return nElems;
            else {
                if(a[curIn]<searchKey)
                    lowerBound=curIn+1;
                else
                    upperBound=curIn-1;
            }
        }
    }
    public void insert(long value){
        int j;
        for(j=0;j<nElems;j++)
            if (a[j]>value)
                break;
        for (int k=nElems;k>j;k--)
            a[k]=a[k-1];
        a[j]=value;
        nElems++;
    }

    //编程作业2.4
    public void inserts(long value){
        //没有元素直接插入
        if(nElems==0) {
            a[0] = value;
            nElems++;
            return;
        }
        int lowerBound=0;
        int upperBound=nElems-1;
        int cutIn;
        while(true){
            cutIn=(lowerBound+upperBound)/2;
            if(lowerBound>upperBound)
                break;
            if(a[cutIn]==value)
                break;//find it
            else if(a[cutIn]<value){
                if(cutIn==nElems-1) {
                    cutIn = cutIn + 1;
                    break;
                }
                else if(a[cutIn+1]>value){
                    cutIn=cutIn+1;
                    break;
                }
                else {
                    lowerBound=cutIn+1;
                }
            }
            else {
                if(cutIn==0){
                    break;
                }
                else if(a[cutIn-1]<=value){
                    break;
                }
                else {
                    upperBound=cutIn-1;
                }
            }
        }
        for(int k=nElems;k>cutIn;k--)
            a[k]=a[k-1];
        a[cutIn]=value;
        nElems++;

    }
    public boolean delete(long value){
        int j=find(value);
        if(j==nElems)
            return false;
        else {
            for (int k=j;k<nElems;k++)
                a[k]=a[k+1];
            nElems--;
            return true;
        }
    }
    public void display(){
        for(int j=0;j<nElems;j++)
            System.out.print(a[j]+" ");
        System.out.println(" ");
    }
    //编程作业2.5
    public OrdArray merge(OrdArray ordArray){
        OrdArray dist=new OrdArray(this.size()+ordArray.size());
        for(int i=0;i<this.size();i++){
            dist.insert(this.a[i]);
        }
        for(int j=0;j<ordArray.size();j++){
            dist.insert(ordArray.a[j]);
        }
        return dist;

    }
}
public class OrderedApp {
    public static void main(String[] args) {
        int maxSize=100;
        OrdArray arr;
        arr=new OrdArray(maxSize);

        //编程作业2.4
        System.out.println("第一个数组：");
        arr.inserts(43);
        arr.inserts(40);
        arr.inserts(41);
        arr.inserts(45);
        arr.inserts(49);
        arr.display();

        //编程作业2.5
        System.out.println("第二个数组：");
        OrdArray arr1=new OrdArray(maxSize);
        arr1.insert(55);
        arr1.insert(33);
        arr1.insert(22);
        arr1.display();
        System.out.println("合并后的数组：");
        OrdArray arr2=arr1.merge(arr);
        arr2.display();
    }

}
