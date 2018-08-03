package shujujiegou.day4;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/10
 * \* Time: 18:26
 */
//双向链表
class Links {
    private int data;
    private Links previous;
    private Links next;

    public Links(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Links getPrevious() {
        return previous;
    }

    public void setPrevious(Links previous) {
        this.previous = previous;
    }

    public Links getNext() {
        return next;
    }

    public void setNext(Links next) {
        this.next = next;
    }

    public void displayLinks() {
        System.out.print(data + " ");
    }


}

class DoublyList {
    private Links first;
    private Links last;

    public DoublyList() {
        first = null;
        last = null;
    }

    public void insertFirst(int data) {
        Links links = new Links(data);
        if (isEmpty())
            last = links;
        else
            first.setPrevious(links);
        links.setNext(first);
        first = links;
    }

    public void insertLast(int data) {
        Links links = new Links(data);
        if (isEmpty())
            first = links;
        else
            last.setNext(links);
        links.setPrevious(last);
        last = links;
    }

    public boolean insertAfter(int key, int data)//在key位置插入value
    {
        if(isEmpty())
            return false;
        else {
            Links links = new Links(data);
            Links temp = first;
            while (temp.getData() != key) {
                temp = temp.getNext();
                if (temp == null)
                    return false;
            }
            if (temp == last) {
                links.setNext(null);
                last = links;
            } else {
                temp.getNext().setPrevious(links);
                links.setNext(temp.getNext());
            }
            links.setPrevious(temp);
            temp.setNext(links);
            return true;
        }
    }

    public Links deleteKey(int key) {
        if(isEmpty())
            return null;
        else {
            Links links = new Links(key);
            Links temp = first;
            while (temp.getData() != links.getData()) {
                temp = temp.getNext();
                if (temp == null)
                    return null;
            }
            if(temp==first){
                first=first.getNext();
                //first.getNext().setPrevious(null);
            }
            else {
                temp.getPrevious().setNext(temp.getNext());
            }
            if (temp == last) {
                //temp.getPrevious().setNext(null);
                last=temp.getPrevious();
            }
            else {
                temp.getNext().setPrevious(temp.getPrevious());
            }
            return temp;
        }
    }

    public Links revoveFirst() {
        Links links = null;
        if (isEmpty())
            return links;
        else {
            links = first;
            //first.getNext().setPrevious(links.getPrevious());
            first = first.getNext();
            return links;
        }
    }

    public Links removeLast() {
        Links links = null;
        if (isEmptys())
            return links;
        else {
            links = last;
            //last.getPrevious().setNext(last.getNext());
            last = last.getPrevious();
            return links;
        }
    }

    public void displayForward() {
        System.out.print("从左往右的链表为:");
        if (isEmpty())
            System.out.print("空");
        else {
            Links links = first;
            while (links != null) {
                links.displayLinks();
                links = links.getNext();
            }
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.print("从右往左的链表为:");
        if (isEmptys())
            System.out.print("空");
        else {
            Links links = last;
            while (links != null) {
                links.displayLinks();
                links = links.getPrevious();
            }
        }

    }

    public boolean isEmpty() {
        return first == null;
    }
    public boolean isEmptys() {
        return last == null;
    }
}

public class DoublyListApp {
    public static void main(String[] args) {

        DoublyList doublyList = new DoublyList();
        doublyList.insertFirst(2);
        doublyList.insertFirst(1);
        doublyList.insertFirst(4);
        doublyList.insertFirst(3);

        doublyList.insertLast(7);
        doublyList.insertLast(8);
        doublyList.insertLast(9);
        doublyList.insertLast(10);
        doublyList.insertLast(77);
        doublyList.insertLast(88);
        doublyList.insertLast(99);
        doublyList.insertLast(100);


        doublyList.insertAfter(4, 5);
//        doublyList.deleteKey(100);
//        doublyList.deleteKey(3);
//        doublyList.deleteKey(5);
//        doublyList.deleteKey(77);

        //doublyList.revoveFirst();
        //doublyList.removeLast();

        doublyList.displayForward();
        doublyList.displayBackward();
//        while (!doublyList.isEmptys()){
//            //doublyList.revoveFirst().displayLinks();
//            doublyList.removeLast().displayLinks();
//        }

    }
}
