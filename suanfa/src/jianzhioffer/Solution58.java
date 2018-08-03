package jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/22
 * \* Time: 16:31
 */
/*
* 请实现一个函数，用来判断一颗二叉树是不是对称的。
* 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
*
* */
public class Solution58 {

    //递归版
    public boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot==null)
            return true;
        return isSymmetrical(pRoot.left,pRoot.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left==null&&right==null)
            return true;
        if (left==null||right==null)
            return false;
        return left.val==right.val
                &&isSymmetrical(left.left,right.right)
                &&isSymmetrical(left.right,right.left);
    }

    //DFS(深度优先遍历)基于栈
    public boolean isSymmetrical1(TreeNode pRoot){

        if (pRoot==null) return false;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(pRoot.left);
        stack.push(pRoot.right);
        while (!stack.isEmpty()){
            TreeNode right=stack.pop();
            TreeNode left=stack.pop();
            if (left==null&&right==null)continue;
            if (left==null||right==null)return false;
            if (left.val!=right.val)return false;

            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    //BFS(广度优先遍历)基于队列
    public boolean isSymmetrical2(TreeNode pRoot){
        if (pRoot==null)return true;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        while (!queue.isEmpty()){
            TreeNode left=queue.poll();
            TreeNode right=queue.poll();

            if (left==null&&right==null)continue;
            if (left==null||right==null)return false;
            if (left.val!=right.val)return false;

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;

    }
}