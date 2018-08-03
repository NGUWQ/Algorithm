package shujujiegou.day9;

import java.io.IOException;
import java.util.Stack;

import static utils.Get.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/25
 * \* Time: 20:56
 */
class Node {
    int key;
    Node leftchild;
    Node rightchild;
}

class Tree {
    private Node root;//表示树的根节点

    public Tree() {
        root = null;
    }

    //二叉树的查找:利用传入的键值来进行查找
    public Node find(int key) {
        Node current = new Node();
        if (root == null)//1.判断根节点为空的情况
            return null;
        else {
            current = root;
            while (current.key != key) //2.判断当前节点和所查询节点之间的关系
            {
                if (current.key < key)
                    current = current.rightchild;//所查询的键值大于当前的键值就从当前节点的右节点开始查找
                else
                    current = current.leftchild;//所查询的键值小于当前的键值就从当前节点的左节点开始查找
                if (current == null)//3.没有找到节点的情况
                    return null;
            }
            return current;//4.返回节点
        }
    }

    //二叉树节点的插入(不能插入相同的值)
    public void insert(int key) {
        Node newNode = new Node();
        newNode.key = key;
        if (root == null)//1.考虑根节点的情况,如果根节点为空的话,就引用给根节点
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) //2.判断所插入节点与当前节点的关系,如果小于就继续寻找左边的节点直至合适的位置。大于右边则寻找右边,相等就不添加。
            {
                parent = current;
                if (current.key == key) {
                    System.out.println(key + "已存在,请换个数吧!");
                    return;
                } else if (current.key < key) {
                    current = current.rightchild;
                    if (current == null) {
                        parent.rightchild = newNode;
                        return;
                    }
                } else {
                    current = current.leftchild;
                    if (current == null) {
                        parent.leftchild = newNode;
                        return;
                    }
                }
            }
        }
    }

    //二叉树节点的删除
    public boolean delete(int key) {
        Node current = root;//当前节点
        Node parent = root;//当前节点父节点
        boolean isLeftChild = true;//设置一个是否是当前节点左节点的标志

        while (current.key != key) //这里的判断和前面的查找,插入一样 ,找到要删除的节点
        {
            parent = current;
            if (current.key > key) {
                isLeftChild = true;
                current = current.leftchild;
            } else {
                isLeftChild = false;
                current = current.rightchild;
            }
            if (current == null)//要删除的节点存在就返回false
                return false;
        }

        //所删除节点没有子节点情况
        if (current.leftchild == null && current.rightchild == null) {
            if (current == root)//1.是否是根节点的情况
                root = null;
            else if (isLeftChild)//当前节点如果是一个左节点的话就把父类左节点的引用指向null
                parent.leftchild = null;
            else
                parent.rightchild = null;//当前节点如果是一个右节点的话就把父类左节点的引用指向null
        } else if (current.rightchild == null) //所删除节点只有一个子节点的情况(此时子节点为左节点)
        {
            if (current == root)
                root = current.leftchild;//当前节点为根节点就把根节点的左子节点的引用指向根节点
            else if (isLeftChild)
                parent.leftchild = current.leftchild;//当前节点为左节点的情况
            else
                parent.rightchild = current.leftchild;//当前节点为右节点的情况
        } else if (current.leftchild == null) //所删除节点只有一个子节点的情况(此时子节点为右节点)
        {
            if (current == root)
                root = current.rightchild;
            else if (isLeftChild)
                parent.leftchild = current.rightchild;
            else
                parent.rightchild = current.rightchild;
        } else //所删除节点有两个子节点的情况
        {
            Node successor = getSuccessor(current);

            if (current == root)
                root = successor;//根节点情况:根节点引用指向替代节点
            else if (isLeftChild)
                parent.leftchild = successor;//左节点情况:父节点的左节点引用指向替代节点
            else
                parent.rightchild = successor;//左节点情况父节点的右节点引用指向替代节点

            successor.leftchild = current.leftchild;//将替代节点的引用指向删除了的节点的左子节点处
        }
        return true;
    }

    //删除节点右两个子节点情况时,返回的最佳替代点.
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;//替代删除节点的父节点
        Node successor = delNode;//替代删除的节点(取所删除节点的右节点里最底层的左子节点)
        Node current = delNode.rightchild;//所删除节点的右子节点

        while (current != null) //所删除节点的右子节点存在
        {
            successorParent = successor;
            successor = current;
            current = current.leftchild;
        }

        if (successor != delNode.rightchild) {
            successorParent.leftchild = successor.rightchild;//替代节点的父节点的左节点引用指向替代节点的右节点(因为此时替代节点就是最后一个有节点)
            successor.rightchild = delNode.rightchild;//替代节点的右节点引用指向要删除节点的右节点
        }
        return successor;//返回替代的节点
    }

    //遍历方法,利用传入的值从而选择遍历的方法
    public void traverse(int traverseType) {

        switch (traverseType) {
            case 1:
                System.out.println("Preorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.println("Inorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.println("Postorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();

    }

    //后序遍历
    private void postOrder(Node localRoot) {

        if (localRoot != null) {
            /*
             * 1.不断递归调用自身的左节点,直至为空
             * 2.不断递归调用自身的右节点,直至为空
             * 3.输出节点
             * */

            postOrder(localRoot.leftchild);
            postOrder(localRoot.rightchild);
            System.out.print(localRoot.key + " ");
        }
    }

    //中序遍历
    private void inOrder(Node localRoot) {

        if (localRoot != null) {
            /*
             * 1.当根节点不为空时,一直递归调用自己的左节点,直至为空,
             * 此时输出当前节点的值。
             * 2.并继续递归调用自己的右节点重复1的操作。*/

            inOrder(localRoot.leftchild);
            System.out.print(localRoot.key + " ");
            inOrder(localRoot.rightchild);
        }
    }

    //前序遍历
    private void preOrder(Node localRoot) {
        /*
         * 1.输出自身节点的值
         * 2.不断递归调用自身的左节点,直至为空
         * 3.不断递归调用自身的右节点,直至为空
         * */
        if (localRoot != null) {
            System.out.print(localRoot.key + " ");
            preOrder(localRoot.leftchild);
            preOrder(localRoot.rightchild);
        }
    }

    //显示二叉树
    public void displayTree() {

        Stack globalStack = new Stack();//定义一个节点栈用来存储二叉树
        globalStack.push(root);
        int nBlanks = 32;//打印节点的初始间隔为32
        boolean isRowEmpty = false;//设置一个标志值,判定一行是否都是空节点
        System.out.println("··································································");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();//临时栈来存放待显示的二叉树
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null)//当前节点不为空就打印
                {
                    System.out.print(temp.key);//打印二叉树的节点
                    localStack.push(temp.leftchild);//将该二叉树的左右节点压入临时栈中
                    localStack.push(temp.rightchild);

                    if (temp.leftchild != null || temp.rightchild != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)//同一行节点之间的间隔
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;//每输出完一行之后，间隔值缩小二分之一
            while (localStack.isEmpty() == false)//临时栈不为空时就把临时栈的节点都放入节点栈中,因为有两次入栈和出栈,所以节点的顺序不会改变
                globalStack.push(localStack.pop());
        }
        System.out.println("··································································");
    }
}

class HashChain {
    private Tree[] array;
    private int size;


    public HashChain(int size) {
        this.size = size;
        array = new Tree[size];
        for (int j=0;j<size;j++)
            array[j]=new Tree();
    }

    public void showTree() {
        for (int j = 0; j < size; j++) {
            System.out.println(j + ".");
            array[j].traverse(2);
        }
    }

    /*public  int method(String string){
        string=string.toLowerCase();
        int hashcode=0;
        for (int i=0;i<string.length();i++)
        {
            int letter=string.charAt(i)-96;
            hashcode=(hashcode*27+letter)%size;
        }
        return hashcode;
    }*/

    public int hashFunc1(int value) {
        return value % size;
    }

    public void insert(int key) {
//        int key=node.key;
//        double value=node.value;
        int hashcode = hashFunc1(key);
        array[hashcode].insert(key);
    }

    public boolean delete(int key) {
        int hashcode = hashFunc1(key);
        boolean booleans = array[hashcode].delete(key);
        return booleans;
    }

    public Node find(int key) {
        int hashcode = hashFunc1(key);
        Node node = array[hashcode].find(key);
        return node;
    }
}

public class HashChainTree {
    public static void main(String[] args) throws IOException {
        System.out.println("1.哈希表的显示(s or S)");
        System.out.println("2.哈希表数据的添加(i or I)");
        System.out.println("3.哈希表数据的查找(f or F)");
        System.out.println("4.哈希表数据的删除(d or D)");
        System.out.println("5.退出程序(q or Q)");
        System.out.println("请输入哈希表的大小(size):");
        int size = getValue();
        HashChain hashChain = new HashChain(size);
        while (true) {
            System.out.println("您想怎么操作哈希表呢?");
            char choice = getChoice();
            if (choice == 'q' || choice == 'Q')
                break;
            else if (choice == 's' || choice == 'S') {
                hashChain.showTree();
            } else if (choice == 'd' || choice == 'D') {
                hashChain.showTree();
                System.out.println("请输入要删除的值:");
                int value = getValue();
                boolean b = hashChain.delete(value);
                if (b == false)
                    System.out.println("没有此数据,删除失败！！！");
                else
                    hashChain.showTree();
            } else if (choice == 'i' || choice == 'I') {
                System.out.println("请输入要添加的值:");
                int value = getValue();
                hashChain.insert(value);
                System.out.println(value + "添加成功");
                //hashChain.showTree();
            }
            else if (choice == 'f' || choice == 'F') {
                int value = getValue();
                Node node = hashChain.find(value);
                if (node == null)
                    System.out.println("查无此值!!!");
                else
                    System.out.println("已找到值" + value);
            } else
                System.out.println("请重新输入!!!");

        }

    }
}
