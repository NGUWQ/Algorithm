package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/24
 * \* Time: 19:58
 */
/*
* 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
* 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
* 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
* 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
* 请问该机器人能够达到多少个格子？
*
*
* */
public class Solution66 {

    //参考剑指offer
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] visited=new boolean[rows][cols];//记录是否已经走过
        return  helper(0,0,rows,cols,visited,threshold);


    }

    private int helper(int i, int j, int rows, int cols, boolean[][] visited, int limit) {

        if (i<0||i>=rows||j<0||j>cols||numSum(i)+numSum(j)>limit||visited[i][j]==true)return  0;
        visited[i][j]=true;
        return helper(i-1,j,rows,cols,visited,limit)+
                helper(i+1,j,rows,cols,visited,limit)+
                helper(i,j-1,rows,cols,visited,limit)+
                helper(i,j+1,rows,cols,visited,limit)+1;
    }

    private int numSum(int i)//将坐标的每个数分离出来
    {
        int sum=0;
        do {
            sum+=i%10;
        }
        while ((i/=10)>0);
        return sum;
    }
}
