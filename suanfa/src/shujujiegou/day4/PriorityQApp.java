package shujujiegou.day4;

import shujujiegou.day4.Link;
import shujujiegou.day4.SortedList;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/12
 * \* Time: 20:58
 */
//编程作业5.1  基于有序链表实现的优先级队列
class PriorityQ{
    private SortedList sortedList;

    public PriorityQ(){
        sortedList=new SortedList();
    }

    public void insert(int key,double value){
        sortedList.insert(key,value);
    }

    public Link remove(){
        return sortedList.remove();
    }

    public boolean isEmpty(){
        return sortedList.isEmpty();
    }

    public void display(){
        sortedList.display();
    }

}
public class PriorityQApp {

    public static void main(String[] args) {

        PriorityQ priorityQ=new PriorityQ();
        priorityQ.insert(11,22.1);
        priorityQ.insert(9,11.1);
        priorityQ.display();
        priorityQ.remove();
        System.out.println();
        priorityQ.display();
    }
}
