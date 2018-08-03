package love;

import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/13
 * \* Time: 19:37
 */
//此程序来解决小唐是否来找我
public class Find {

    public static void main(String[] args) {
        Random r=new Random();
        int love=1314520;
        while (love>0) {
            int lucky=r.nextInt(2);
            if (lucky == 1)
                break;
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t经"+love+"次测试后,小唐还是要来找我！");
    }
}
