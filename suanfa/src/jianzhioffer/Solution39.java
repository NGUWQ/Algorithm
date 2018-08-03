package jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/11
 * \* Time: 21:01
 */
/*
*输入一棵二叉树，求该树的深度。
* 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
* 最长路径的长度为树的深度。
*  */
public class Solution39 {
    //非递归
    public int TreeDepth(TreeNode root) {
        if (root==null)
            return 0;
        int depth=0,count=0,nextcount=1;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size()!=0){
            TreeNode node=queue.poll();
            count++;
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
            if (count==nextcount){
                nextcount=queue.size();
                count=0;
                depth++;
            }
        }
        return depth;
    }
    //递归
    public int TreeDepth1(TreeNode root) {
        if (root==null)
            return 0;
        int left=TreeDepth1(root.left);
        int right=TreeDepth1(root.right);
        return Math.max(left,right)+1;
    }
}
