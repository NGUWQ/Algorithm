package ceshi;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/23
 * \* Time: 20:55
 */
public class CutApp {
    static int count=16;
    Integer i=16;


    public static void cut(int left,int right){
        if (right==left||right==1) {
            count--;
            System.out.println("第"+count+"次"+right);
        }
        else {
            int mid = (left + right) / 2;
            cut(left,mid);
            cut(mid+1,right);
        }

    }

    public  int method(){
         Integer x=i;
         i+=2;
         return x;
    }
    public static void main(String[] args) {
        //cut(0,15);
        System.out.println(new CutApp().method());
    }
}
