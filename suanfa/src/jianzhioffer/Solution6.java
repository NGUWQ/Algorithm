package jianzhioffer;


/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/27
 * \* Time: 9:20
 */

/*
*输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
* 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
* 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
* 则重建二叉树并返回。
 */
//Definition for binary tree
/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
*/
public class Solution6 {


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {


        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return  root;

    }

    //递归:根据前序和中序序列可以分别确定根节点的位置,
    // 自此就可以找出左右节点,然后将每一个子节点都当作跟去寻找它的左右节点,一直递归下去在,直到不满足条件
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre,
                                           int[] in, int startIn, int endIn) {

        if (startIn>endIn||startPre>endPre)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);//从前序序列获取当前树的根节点
        for (int i=startIn;i<=endIn;i++)
        {
            if (in[i]==pre[startPre])//找出根节点在中序序列中的位置
            {
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,
                        in,startIn,i-1);//该根节点的左子节点,由每次递归的endIn值可知该根节点有多少个左子节点,
                // startIn相当于一个根记录点,来标记有左右子节点的根
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,
                        endPre,in,i+1,endIn);//该根节点的右子节点,startIn记录了根的右节点的位置
                break;
            }
        }
        return root;
    }
}

















/*
*
*
*   TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1,
                in, 0, in.length - 1);
        return root;
    }
//前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre,
                                           int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1,
                        startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1,
                        endPre, in, i + 1, endIn);
                break;
            }

        return root;*/