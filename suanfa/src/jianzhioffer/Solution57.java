package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/22
 * \* Time: 13:25
 */
/*
* 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
* 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
*
* */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Solution57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode==null)
            return null;
        if (pNode.right!=null){//如果右右子树,就找右子树的最左节点
            pNode=pNode.right;
            while (pNode.left!=null)
                pNode=pNode.left;
            return pNode;
        }
        //没有右子树,就找第一个当前节点是父节点左孩子的节点
        while (pNode.next!=null){
            if (pNode.next.left==pNode)
                return pNode.next;
            pNode=pNode.next;
        }
        return null;

    }
}
