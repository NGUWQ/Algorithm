package shujujiegou.day5;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/14
 * \* Time: 14:42
 */
//汉诺塔问题(递归)
public class TowersApp
{
    static int nDisks = 3;
    static int count=0;

    public static void main(String[] args)
    {
        doTowers(nDisks, 'A', 'B', 'C');
        System.out.println(nDisks+"个盘子从汉诺塔上排列需要"+count+"次");
    }

    private static void doTowers(int n, char from, char inter, char to) {
        count++;
        if (n==1)
            System.out.println(n+" form "+from+" to "+to);
        else {
            doTowers(n-1,from,to,inter);
            System.out.println(n+" form "+from+" to "+to);
            doTowers(n-1,inter,from,to);
        }
    }

}