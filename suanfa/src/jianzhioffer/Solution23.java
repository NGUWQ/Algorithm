package jianzhioffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/31
 * \* Time: 22:46
 */
//从上往下打印出二叉树的每个节点，同层节点从左至右打印。
public class Solution23 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (root == null)
            return arrayList;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode i = deque.pop();
            arrayList.add(i.val);
            if (i.left!=null)deque.add(i.left);
            if (i.right!=null)deque.add(i.right);
        }
        return arrayList;
    }

    public static void main(String[] args) {

    }
}
