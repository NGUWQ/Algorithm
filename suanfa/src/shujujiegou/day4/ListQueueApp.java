package shujujiegou.day4;

import shujujiegou.day4.FirstLastLink;
import shujujiegou.day4.Link;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/8
 * \* Time: 16:10
 */
//双端链表实现队列
class ListQueue{
    private FirstLastLink fll;

    public ListQueue(){
        fll=new FirstLastLink();
    }

    public boolean isEmpty(){
        return fll.isEmpty();
    }

    public void insert(int key,double value){
        fll.insertLast(key,value);
    }

    public Link remove(){
        return fll.deleteFirst();
    }

    public void display(){
        System.out.print("队列的");
        fll.displayFirstLast();
    }

}
public class ListQueueApp {

    public static void main(String[] args) {

        ListQueue lq=new ListQueue();
        lq.insert(11,22.0);
        lq.insert(22,33.0);
        lq.display();
        System.out.println();
        System.out.print("移除:");
        while (!lq.isEmpty()){
            lq.remove().displayLink();
        }
        System.out.println();
        lq.display();

    }
}
