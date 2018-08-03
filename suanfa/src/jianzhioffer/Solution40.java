package jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/12
 * \* Time: 0:39
 */
/*输入一棵二叉树，判断该二叉树是否是平衡二叉树。*/
public class Solution40 {
    public boolean IsBalanced_Solution(TreeNode root) {

        if (root==null)
            return true;
        return Math.abs(IsBalanced(root.left)-IsBalanced(root.right))<=1;


    }
    private int IsBalanced(TreeNode root) {
        if (root==null)
            return 0;
        return Math.max(IsBalanced(root.left),IsBalanced(root.right))+1;
    }

    public boolean IsBalanced_Solution1(TreeNode root){
       return getDepth(root)!=-1;

    }

    private int getDepth(TreeNode root) {
        if (root==null)
            return 0;
        int left=getDepth(root.left);
        if (left==-1) return -1;
        int right=getDepth(root.right);
        if (right==-1) return -1;
        return Math.abs(left-right)>1?-1:1+Math.max(left,right);
    }
}
