package shujujiegou.day4;

import shujujiegou.day4.Link;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/8
 * \* Time: 14:57
 */
//双端队列的简单实现
class FirstLastLink {
    private Link first;
    private Link last;

    public FirstLastLink() {
        first = null;
        last = null;
    }

    public void insertFirst(int key, double value) {
        Link link = new Link(key, value);
        if (isEmpty())
            last = link;
        link.setNext(first);
        first = link;
    }

    public void insertLast(int key, double value) {
        Link link = new Link(key, value);
        if (isEmpty())
            first = link;
        else
            last.setNext(link);
        last = link;
    }

    public Link deleteFirst() {
        if (!isEmpty()) {
            Link link = first;
            if (first.getNext() == null)
                last = null;
            first = first.getNext();
            return link;
        } else
            return null;
    }

    public void displayFirstLast() {
        System.out.print("链表为:");
        if (isEmpty()) {
            System.out.println("空");
        }
        else {
            Link current = first;
            while (current != null) {
                current.displayLink();
                current = current.getNext();
            }
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }
}

public class FirstLastLinkApp {
    public static void main(String[] args) {

        FirstLastLink fl = new FirstLastLink();
        fl.insertFirst(22, 33.3);
        fl.insertFirst(33, 44.1);
        fl.insertLast(44, 55.2);
        fl.displayFirstLast();
        System.out.println();
        while (!fl.isEmpty()) {
            Link link = fl.deleteFirst();
            link.displayLink();
        }
    }
}
