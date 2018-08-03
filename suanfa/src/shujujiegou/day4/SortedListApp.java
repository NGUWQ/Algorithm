package shujujiegou.day4;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/8
 * \* Time: 20:37
 */
//有序链表
class SortedList {
     private Link first;

    public SortedList() {
        first = null;
    }

    public void insert(int key, double value) {
        Link link = new Link(key, value);
        Link previous = null;
        Link current = first;
        while (current != null && current.getI() <= key && current.getD() <= value) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null)
            first = link;
        else
            previous.setNext(link);
        link.setNext(current);
    }

    public Link remove() {
        Link current = null;
        if (!isEmpty()) {
            current = first;
            first = current.getNext();
            return current;
        } else
            return current;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void display() {
        System.out.print("链表为：");
        if (isEmpty())
            System.out.print("空");
        else {
            Link current = first;
            while (current != null) {
                current.displayLink();
                current = current.getNext();
            }
        }
    }
}

public class SortedListApp {

    public static void main(String[] args) {

        SortedList sl = new SortedList();
        sl.insert(10, 22.3);
        sl.insert(10, 22.4);
        sl.insert(11, 33.2);
        sl.insert(11, 33.1);
        sl.insert(9, 11.4);
        sl.display();
        System.out.println();
        System.out.print("删除:");
        while (!sl.isEmpty()){
            sl.remove().displayLink();
        }
    }
}
