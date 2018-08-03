package jianzhioffer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/23
 * \* Time: 20:31
 */
/*
 *
 * 给定一颗二叉搜索树，请找出其中的第k小的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，
 * 按结点数值大小顺序第三个结点的值为4。
 * */
public class Solution62 {

    TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode min = null;
        if (pRoot == null||k<1)
            return min;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> lists = new LinkedList<Integer>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            min = queue.remove();
            if (min != null) {
                lists.add(min.val);
                queue.offer(min.left);
                queue.offer(min.right);
            }
        }
        Collections.sort(lists);
        if (k<lists.size()+1) {
            min = new TreeNode(lists.get(k - 1));
            return min;
        }
        else
            return null;

    }
    int index = 0; //计数器
    TreeNode KthNode2(TreeNode root, int k)
    {
        if(root != null){ //中序遍历寻找第k个
            TreeNode node = KthNode2(root.left,k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return root;
            node = KthNode2(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }
    TreeNode KthNode3(TreeNode root, int k){
        if (root==null)
            return null;
        int count=0;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if (++count==k)
                return root;
            root=root.right;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(6);
        System.out.println(new Solution62().KthNode3(node,3).val);
    }
}
