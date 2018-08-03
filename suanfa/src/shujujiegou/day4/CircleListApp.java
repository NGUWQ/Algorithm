package shujujiegou.day4;

import org.omg.CORBA.DATA_CONVERSION;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/13
 * \* Time: 17:20
 */
class Node{
    private int data;
    private Node next;

    public Node(int data){
        this.data=data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void show(){
        System.out.print(data+" ");
    }
}
class CircleList{
    private Node first;

    public CircleList(){
        first=null;
    }

    public void insert(int data){
        Node node=new Node(data);
        if (first==null){
            first=node;
            node.setNext(first);
        }
        else {
            node.setNext(first);
            first=node;
        }
    }

    public Node delete(){
        Node node=first;
        first=first.getNext();
        Node node1=first.getNext();
        if (node1==node){
            node=node.getNext();
        }
        return node;

    }
}
public class CircleListApp {
}
