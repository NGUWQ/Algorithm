package jianzhioffer;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/23
 * \* Time: 15:01
 */
/*
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * */
public class Solution60 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null)
            return al;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        queue.add(null);
        queue.add(pRoot);
        while (queue.size() != 1) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                Iterator<TreeNode> iter = queue.iterator();
                while (iter.hasNext()) {
                    TreeNode tree = iter.next();
                    list.add(tree.val);
                }
                al.add(new ArrayList<Integer>(list));
                list.clear();
                queue.add(null);
                continue;
            }
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return al;

    }

    ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list=new ArrayList<Integer>();;
        if (pRoot==null)
            return al;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            int low = 0, high = queue.size();
            while (low++ < high) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            if (!list.isEmpty()) {
                al.add(new ArrayList<Integer>(list));
                list.clear();
            }
        }
        return al;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(4);
        node.right = new TreeNode(6);

        ArrayList<ArrayList<Integer>> a = new Solution60().Print2(node);
        System.out.println(a);
    }
}
