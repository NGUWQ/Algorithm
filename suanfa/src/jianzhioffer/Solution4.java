package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/26
 * \* Time: 20:20
 */
/*
* 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
* 每一列都按照从上到下递增的顺序排序。请完成一个函数，
* 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
* */
public class Solution4 {
    public boolean Find(int target, int [][] array) {

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++)
            {
                if(array[i][j]==target)
                    return true;
            }
        }

        return false;


    }
}
