package shujujiegou.day4;

import java.util.Scanner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/7
 * \* Time: 15:23
 */
//简单链表
class Link{
    private int i;
    private double d;
    private Link next;

    Link(int i,double d){
        this.i=i;
        this.d=d;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public void displayLink(){
        System.out.print("{"+i+","+d+"}"+",");

    }
}

class LinkList{
    private Link first;

    public LinkList(){
        first=null;
    }

    public boolean isEmpty(){
        return (first==null);
    }

    public void insertFirst(int i,double d){
        Link link=new Link(i,d);
        link.setNext(first);
        first=link;
    }

    public Link deleteFirst(){
        if (!this.isEmpty()){
            Link links=first;
            first=first.getNext();
            return links;
        }
        else
            return null;
    }

    public Link find(int key){
        Link current=first;
        while (current.getI()!=key){
            if(current.getNext()==null)
                return null;
            else{
                current=current.getNext();
            }
        }
        return current;

    }

    public Link delete(int key){
        Link current=first;
        Link previous=first;
        while (current.getI()!=key){
            if(current.getNext()==null)
                return null;
            else{
                previous=current;
                current=current.getNext();
            }
        }
        if(current==first)
            first=first.getNext();
        else {
            previous.setNext(current.getNext());
        }
        return current;
    }

    public void displayLinkList(){
        System.out.print("链表为：");
        if (isEmpty())
            System.out.println("空");
        else {
            Link current = first;
            while (current != null) {
                current.displayLink();
                current = current.getNext();
            }
            System.out.println();
        }

    }


}
public class LinkListApp {
    public static void main(String[] args) {

        LinkList linkList=new LinkList();
        linkList.insertFirst(22,33.5);
        linkList.insertFirst(33,33.5);
        linkList.insertFirst(44,33.5);
        linkList.insertFirst(55,33.5);
        linkList.insertFirst(66,33.5);
        linkList.insertFirst(77,33.5);

        linkList.displayLinkList();

        //linkList.delete(44);
        System.out.println("请输入您要查找的链结点:");
        Scanner scanner=new Scanner(System.in);
        int key=scanner.nextInt();
        boolean flag=true;
        while (flag) {
            try {
                Link f = linkList.find(key);
                f.displayLink();
                flag=false;

            } catch (Exception e) {
                System.out.println("没有" + key + "此链结点");
                flag=false;
            }
        }

//        while (!linkList.isEmpty()){
//            Link l=linkList.deleteFirst();
//            System.out.print("删除:");
//            l.displayLink();
//            System.out.println();
//        }


    }
}
