package shujujiegou.day4;

import shujujiegou.day4.Link;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/9
 * \* Time: 15:58
 */
//表插入排序,利用链表从数组中获得无序的数据，
// 链表排序完成后，再删除存到数组中，从而实现排序。效率比用数组插入排序稍高。
class ListInsert {

    private Link first;

    public ListInsert() {
        first = null;
    }

    public ListInsert(Link[] linkArr) {
        first = null;
        for (int i = 0; i < linkArr.length; i++)
            insert(linkArr[i]);
    }

    public void insert(Link l) {
        Link current = first;
        Link previous = null;

        while (current != null && current.getI() < l.getI() && current.getD() < l.getD()) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null)
            first = l;
        else
            previous.setNext(l);
        l.setNext(current);
    }

    public Link remove() {
        Link current = null;
        if (isEmpty())
            return current;
        else{
            current = first;
        if (current != null)
            first = first.getNext();
        return current;
        }
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void display(){
        Link current=first;
        while (current!=null){
            current.displayLink();
            current=current.getNext();
        }
    }

}

public class ListInsertApp {
    public static void main(String[] args) {

        Link[] links={new Link(11,22.0),new Link(9,11.0),new Link(2,1.3)};
        System.out.print("排序前:");
        for (int i=0;i<links.length;i++)
            links[i].displayLink();
        System.out.println();
        ListInsert listInsert=new ListInsert(links);
        for (int j=0;j<links.length;j++)
            links[j]=listInsert.remove();
        System.out.print("排序后:");
        for (int k=0;k<links.length;k++)
            links[k].displayLink();

    }
}
