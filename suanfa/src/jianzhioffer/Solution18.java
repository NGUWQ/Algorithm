package jianzhioffer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/29
 * \* Time: 14:31
 */
/*输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）*/

/*解析过程:

* */
class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
public class Solution18 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result=false;//标志量
        if (root1!=null&&root2!=null)//两棵树都不为空
        {

            if (root1.val==root2.val)//判断根节点是否相等,相等就进一步判断它的左右子节点
            {
                result=isSubTree(root1,root2);
            }
            if (!result)
                result=HasSubtree(root1.left,root2);//当前根节点不想等,判断其左子节点(递归)
            if (!result)
                result=HasSubtree(root1.right,root2);//当前根节点不想等,判断其右子节点(递归)
        }
        return result;
    }
    private boolean isSubTree(TreeNode root1, TreeNode root2)//判断子节点是否相同
    {
        //递归比较中,如果树1为空,而树2不为空。
        // 就说明树2不是当前树1的子树,反之如果树2为空,树1不为空,就说明在树1中找到了子树树2

        if (root1==null&&root2!=null)
            return false;
        if (root2==null)
            return true;
        if (root1.val!=root2.val)//两树都不空时,就比较他们的值
            return false;
        return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
    }
}