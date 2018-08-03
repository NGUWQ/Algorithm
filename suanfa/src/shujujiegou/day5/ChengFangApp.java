package shujujiegou.day5;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/17
 * \* Time: 21:10
 */
//求一个数的乘方(递归)
public class ChengFangApp
{
    public static int method(int x,int y)
    {
        if (y==1){
            return x;
        }
        else if(y%2==0){
            return method(x * x, y / 2);
        }
        else {
                return x*method(x * x, y / 2);
        }
    }
    public static void main(String[] args)
    {
            int result=method(2,10);
            System.out.println(result);

    }
}
