package jianzhioffer;

import java.util.Arrays;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/18
 * \* Time: 17:42
 */
/*
*
* LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,
* 2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,
* 看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,
* 嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
* 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
* 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
* LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。
 * 为了方便起见,你可以认为大小王是0。*/
public class Solution46 {
    public boolean isContinuous(int [] numbers) {
        int havezero=0;
        int decline=0;
        if (numbers.length==0||numbers==null)
            return false;
        Arrays.sort(numbers);//排序
        for (int i=0;i<numbers.length-1;i++){
            if (numbers[i]==0)//计算癞子数量
            {
                havezero++;
                continue;
            }
            if (numbers[i]==numbers[i+1])//判断是否有对子
                return false;
            decline+=numbers[i+1]-numbers[i]-1;//计算总的值差
        }
        if (havezero>=decline)//癞子数大于或等于值差说明可以组成顺子
            return true;
        return false;

    }

    public static void main(String[] args) {

        int[] numbers={9,0,0,3,5};
        System.out.println(new Solution46().isContinuous(numbers));
    }
}
