package jianzhioffer;

import java.util.ArrayList;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/3
 * \* Time: 21:34
 */
/*输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
* */
public class Solution25 {
    private ArrayList<ArrayList<Integer>> listAll=new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list=new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root==null)
            return listAll;
        list.add(root.val);
        target-=root.val;
        if (target==0&&root.left==null&&root.right==null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return listAll;

    }
}
