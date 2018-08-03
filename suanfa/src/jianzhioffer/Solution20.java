package jianzhioffer;

import java.util.ArrayList;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/29
 * \* Time: 18:51
 */
/*
* 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
* 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
* 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
* */
public class Solution20 {
    public ArrayList<Integer> printMatrix1(int [][] matrix) {

        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        int j=0;//控制纵向
        int k=0;//控制横向
        for (int i=0;i<1;i++)
        {
            while (j<matrix[i].length-1)
            {
                arrayList.add(matrix[k][j]);
                j++;

          }
            while (k<=j) {
                arrayList.add(matrix[k][j]);
                k++;
            }
            k--;
            j--;
            //---------------------------------------------
            while (j>0) {
                arrayList.add(matrix[k][j]);
                j--;
            }
            while (k>j)
            {
                arrayList.add(matrix[k][j]);
                k--;
            }
//            ////---------------------------------------------
            k++;
            j++;
            while (j<matrix[i].length-2)
            {
                arrayList.add(matrix[k][j]);
                j++;
            }

            while (k<matrix.length-1)
            {
                arrayList.add(matrix[k][j]);
                k++;
            }
            //---------------------------------------------
            arrayList.add(matrix[k-1][j-1]);


        }
        return arrayList;

    }

    public ArrayList<Integer> printMatrix2(int [][] matrix){

        int row=matrix.length;
        int col=matrix[0].length;
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        if (row==0||col==0)
            return arrayList;
        int left=0,top=0,right=col-1,bottom=row-1;
       while (left<=right&&top<=bottom){

            //左到右
            for (int i=left;i<=right;++i)arrayList.add(matrix[left][i]);
            //上到下
            for (int i=top+1;i<=bottom;++i)arrayList.add(matrix[i][right]);
            //右往左
            if (top!=bottom)
            for (int i=right-1;i>=left;--i)arrayList.add(matrix[bottom][i]);
            //下往上
            if (left!=right)
            for (int i=bottom-1;i>top;--i)arrayList.add(matrix[i][left]);
            left++;
            top++;
            right--;
            bottom--;
        }
        return arrayList;
    }

    public ArrayList<Integer> printMatrix3(int [][] matrix){

        int row=matrix.length;
        int col=matrix[0].length;
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        if (row==0||col==0)
            return arrayList;
        /*letf,top:左上角的行和列
        right,bottom,右下角的行和列
        * */
        int left=0,top=0,right=row-1,bottom=col-1;
        while (left<=right&&top<=bottom){

            //左到右
            for (int i=top;i<=bottom;++i)arrayList.add(matrix[left][i]);
            //上到下
            for (int i=left+1;i<=right;++i)arrayList.add(matrix[i][bottom]);
            //右往左
            if (left!=right)
                for (int i=bottom-1;i>=top;--i)arrayList.add(matrix[right][i]);
           //下往上
            if (top!=bottom)
                for (int i=right-1;i>left;--i)arrayList.add(matrix[i][top]);
            left++;
            top++;
            right--;
            bottom--;
        }
        return arrayList;
    }

    public static void main(String[] args) {
        Solution20 s=new Solution20();
        int [][] matrix={{1,2},{5,3},{9,4},{12,5}};

        ArrayList<Integer>  arrayList=s.printMatrix3(matrix);
        System.out.println(arrayList);
    }
}
