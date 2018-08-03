package jianzhioffer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/23
 * \* Time: 16:53
 */
/*
* 请实现两个函数，分别用来序列化和反序列化二叉树*/
public class Solution61 {
    public int index=-1;
    String Serialize(TreeNode root) {
        StringBuffer sb=new StringBuffer();
        if (root==null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();

    }
    TreeNode Deserialize(String str) {
        index++;
        int length=str.length();
        if (index>=length)
            return null;
        String[] strr=str.split(",");
        TreeNode node=null;
        if (!strr[index].equals("#")){
            node=new TreeNode(Integer.valueOf(strr[index]));
            node.left=Deserialize(str);
            node.right=Deserialize(str);
        }
        return node;

    }

    String Serialize1(TreeNode root) {
        StringBuffer sb=new StringBuffer();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if (root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            TreeNode node=queue.remove();
            if (node!=null){
                sb.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
            else
                sb.append("#,");
        }
        if (sb.length()!=0)
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    TreeNode Deserialize1(String str) {
        TreeNode head=null;
        if (str==null||str.length()==0)
            return head;
        String[] strt=str.split(",");
        TreeNode[] treeNodes=new TreeNode[strt.length];
        for (int i=0;i<strt.length;i++){
            if (!strt[i].equals("#"))
                treeNodes[i]=new TreeNode(Integer.valueOf(strt[i]));
        }
        for (int i=0,j=1;j<treeNodes.length;i++){
            if (treeNodes[i]!=null){
                treeNodes[i].left=treeNodes[j++];
                treeNodes[i].right=treeNodes[j++];
            }
        }
        return treeNodes[0];
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(4);
        node.right = new TreeNode(6);
        String str=new Solution61().Serialize(node);
        System.out.println(new Solution61().Deserialize(str).val);
    }
}
