package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/4
 * \* Time: 17:28
 */
/*输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
* */
//用中序遍历即可
public class Solution27 {
    TreeNode head=null;
    TreeNode tail=null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return head;

    }

    private void ConvertSub(TreeNode pRootOfTree) {
        if (pRootOfTree==null)
            return;
        ConvertSub(pRootOfTree.left);
        if (head==null)
        {
            head=pRootOfTree;
            tail=pRootOfTree;
        }
        else {
            tail.right=pRootOfTree;
            pRootOfTree.left=tail;
            tail=pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }
}
