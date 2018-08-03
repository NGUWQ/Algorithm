package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/29
 * \* Time: 17:16
 */
//操作给定的二叉树，将其变换为源二叉树的镜像。
public class Solution19 {

    public void Mirror(TreeNode root) {

        TreeNode temp;
        if (root!=null){
            temp=root.left;
            root.left=root.right;
            root.right=temp;
            Mirror( root.left);
            Mirror( root.right);
        }

    }

}
