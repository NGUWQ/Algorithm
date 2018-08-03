package jianzhioffer;

import java.util.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/22
 * \* Time: 19:19
 */
/*请实现一个函数按照之字形打印二叉树，
即第一行按照从左到右的顺序打印，
第二层按照从右至左的顺序打印，
第三行按照从左到右的顺序打印，其他行以此类推。*/
public class Solution59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;

        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(pRoot);
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        while (!s1.empty() || !s2.empty()) {
//            if (layer % 2 != 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            while (!s1.empty()) {
                TreeNode node = s1.pop();
                if (node != null) {
                    temp.add(node.val);
                    s2.push(node.left);
                    s2.push(node.right);
                }
            }
            if (!temp.isEmpty()) {
                list.add(temp);
//                    layer++;
            }
//            }
//            else {
            temp = new ArrayList<Integer>();
            while (!s2.empty()) {
                TreeNode node = s2.pop();
                if (node != null) {
                    temp.add(node.val);
                    s1.push(node.right);
                    s1.push(node.left);
                }
            }
            if (!temp.isEmpty()) {
                list.add(temp);
//                    layer++;
            }
        }
//        }
        return list;
    }
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>();
        if (pRoot==null)
            return al;
        ArrayList<Integer> list=new ArrayList<Integer>();
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        boolean flag=true;
        queue.addLast(null);//设置层分隔符
        queue.addLast(pRoot);
        while (queue.size()!=1){
            TreeNode node=queue.removeFirst();
            if (node==null){//到达层分隔符
                Iterator<TreeNode> iter=null;
                if (flag)
                    iter=queue.iterator();//从前往后遍历
                else
                    iter=queue.descendingIterator();//从后往前遍历
                flag=!flag;
                while (iter.hasNext()){
                    TreeNode tree=iter.next();
                    list.add(tree.val);
                }
                al.add(new ArrayList<Integer>(list));
                list.clear();
                queue.addLast(null);//设置层分隔符
                continue;
            }
            if (node.left!=null)
                queue.addLast(node.left);
            if (node.right!=null)
                queue.addLast(node.right);

        }
        return al;

    }



    public static void main(String[] args) {

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(6);
        node.left.right = new TreeNode(7);
        node.left.left = new TreeNode(8);
        node.right.right = new TreeNode(7);
        node.right.left = new TreeNode(8);

        ArrayList<ArrayList<Integer>> a = new Solution59().Print(node);
        System.out.println(a);
    }
}
