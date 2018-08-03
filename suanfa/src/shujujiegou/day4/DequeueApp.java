package shujujiegou.day4;

import shujujiegou.day4.DoublyList;
import shujujiegou.day4.Links;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/12
 * \* Time: 22:16
 */
//编程作业5.2 基于双向链表实现的双端队列
class Dequeue{
    private DoublyList doublyList;

    public Dequeue(){
        doublyList=new DoublyList();
    }

    public void insertLeft(int data){
        doublyList.insertFirst(data);
    }

    public void insertRight(int data){
        doublyList.insertLast(data);
    }

    public Links removeLeft(){
        return doublyList.revoveFirst();
    }

    public Links removeRight(){
        return doublyList.removeLast();
    }

    public boolean isEmpty(){
        return doublyList.isEmpty();
        //return doublyList.isEmptys();
    }

    public void display(){
        doublyList.displayForward();
    }
}
public class DequeueApp {

    public static void main(String[] args) {

        Dequeue dequeue=new Dequeue();
        dequeue.insertLeft(33);
        dequeue.insertLeft(44);
        dequeue.insertLeft(55);

        dequeue.insertRight(66);
        dequeue.insertRight(77);
        dequeue.insertRight(88);

        dequeue.display();

        System.out.print("删除:");
        while (!dequeue.isEmpty()){
            Links links = dequeue.removeLeft();
            links.displayLinks();
        }
    }
}
