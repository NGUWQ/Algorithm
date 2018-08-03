package shujujiegou.day5;

import com.sun.org.apache.regexp.internal.RE;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/19
 * \* Time: 11:49
 */
//编程作业6.2 实现5行二叉树的输出(递归)
public class TreeApp {

    private  char[][] lines;

    //number一行最大显示字符数
    public TreeApp(int number){
        int rows=1;
        int numberDivide=number;
        while ((numberDivide=numberDivide/2)!=0){
            //行数rows和number的关系
            rows++;
        }
        lines=new char[rows][number];

        for (int i=0;i<rows;i++){
            //初始化数组
            for (int j=0;j<number;j++){
                lines[i][j]='-';
            }
        }
    }

    public void display(){
        for (int i=0;i<lines.length;i++){
            //初始化数组
            for (int j=0;j<lines[i].length;j++)
                System.out.print(lines[i][j]);
            System.out.println();
        }
    }

    public void makeBranches(int left,int right){
        int number=right-left+1;
        int row=0;
        int numberDivide=number;
        while ((numberDivide=numberDivide*2)<=lines[0].length){
            row++;
        }
        if (number==1){
            //基值条件
            lines[row][left]='X';
            return;
        }
        else {
            int mid=(left+right)/2+1;
            lines[row][mid]='X';
            makeBranches(left,mid-1);
            makeBranches(mid,right);
        }
    }
    public void  makeTree(){
        makeBranches(0,lines[0].length-1);
    }

    public static void main(String[] args) {

        TreeApp t=new TreeApp(16);
        //t.makeTree();
        t.display();
    }
}
