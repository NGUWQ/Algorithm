package shujujiegou.day4;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/11
 * \* Time: 16:04
 */
// interIterator.java
// demonstrates iterators on a linked listListIterator
// to run this program: C>java InterIterApp
//迭代器的实现
import shujujiegou.day4.Links;

import java.io.*;                 // for I/O
class LinkLists
{
    private Links first;            // ref to first item on list

    // -------------------------------------------------------------
    public LinkLists()              // constructor
    { first = null; }           // no items on list yet
    // -------------------------------------------------------------
    public Links getFirst()         // get value of first
    { return first; }
    // -------------------------------------------------------------
    public void setFirst(Links f)   // set first to new link
    { first = f; }
    // -------------------------------------------------------------
    public boolean isEmpty()       // true if list is empty
    { return first==null; }
    // -------------------------------------------------------------
    public ListIterator getIterator()  // return iterator
    {
        return new ListIterator(this);  // initialized with
    }                               //    this list
    // -------------------------------------------------------------
    public void displayList()
    {
        Links current = first;       // start at beginning of list
        while(current != null)      // until end of list,
        {
            current.displayLinks();   // print data
            current = current.getNext();  // move to next link
        }
        System.out.println("");
    }
// -------------------------------------------------------------
}  // end class LinkList
////////////////////////////////////////////////////////////////
class ListIterator
{
    private Links current;          // current link
    private Links previous;         // previous link
    private LinkLists ourList;      // our linked list
    //--------------------------------------------------------------
    public ListIterator(LinkLists list) // constructor
    {
        ourList = list;
        reset();
    }
    //--------------------------------------------------------------
    public void reset()            // start at 'first'
    {
        current = ourList.getFirst();
        previous = null;
    }
    //--------------------------------------------------------------
    public boolean atEnd()         // true if last link
    { return (current.getNext()==null); }
    //--------------------------------------------------------------
    public void nextLink()         // go to next link
    {
        previous = current;
        current = current.getNext();
    }
    //--------------------------------------------------------------
    public Links getCurrent()       // get current link
    { return current; }
    //--------------------------------------------------------------
    public void insertAfter(int dd)     // insert after
    {                                 // current link
        Links newLink = new Links(dd);

        if( ourList.isEmpty() )     // empty list
        {
            ourList.setFirst(newLink);
            current = newLink;
        }
        else                        // not empty
        {
            newLink.setNext(current.getNext());
            current.setNext(newLink);
            nextLink();              // point to new link
        }
    }
    //--------------------------------------------------------------
    public void insertBefore(int dd)    // insert before
    {                                 // current link
        Links newLink = new Links(dd);

        if(previous == null)        // beginning of list
        {                        // (or empty list)
            newLink.setNext(ourList.getFirst());
            ourList.setFirst(newLink);
            reset();
        }
        else                        // not beginning
        {
            newLink.setNext(previous.getNext());
            previous.setNext(newLink);
            current = newLink;
        }
    }
    //--------------------------------------------------------------
    public int deleteCurrent()    // delete item at current
    {
        int value = current.getData();
        if(previous == null)        // beginning of list
        {
            ourList.setFirst(current.getNext());
            reset();
        }
        else                        // not beginning
        {
            previous.setNext(current.getNext());
            if( atEnd() )
                reset();
            else
                current = current.getNext();
        }
        return value;
    }
//--------------------------------------------------------------
}  // end class ListIterator
////////////////////////////////////////////////////////////////
public class InterIterApp
{
    public static void main(String[] args) throws IOException
    {
        LinkLists theList = new LinkLists();           // new list
        ListIterator iter1 = theList.getIterator();  // new iter
        int value;

        iter1.insertAfter(20);             // insert items
        iter1.insertAfter(40);
        iter1.insertAfter(80);
        iter1.insertBefore(60);

        while(true)
        {
            System.out.print("Enter first letter of show, reset, ");
            System.out.print("next, get, before, after, delete: ");
            System.out.flush();
            int choice = getChar();         // get user's option
            switch(choice)
            {
                case 's':                    // show list
                    if( !theList.isEmpty() )
                        theList.displayList();
                    else
                        System.out.println("List is empty");
                    break;
                case 'r':                    // reset (to first)
                    iter1.reset();
                    break;
                case 'n':                    // advance to next item
                    if( !theList.isEmpty() && !iter1.atEnd() )
                        iter1.nextLink();
                    else
                        System.out.println("Can't go to next link");
                    break;
                case 'g':                    // get current item
                    if( !theList.isEmpty() )
                    {
                        value = iter1.getCurrent().getData();
                        System.out.println("Returned " + value);
                    }
                    else
                        System.out.println("List is empty");
                    break;
                case 'b':                    // insert before current
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertBefore(value);
                    break;
                case 'a':                    // insert after current
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertAfter(value);
                    break;
                case 'd':                    // delete current item
                    if( !theList.isEmpty() )
                    {
                        value = iter1.deleteCurrent();
                        System.out.println("Deleted " + value);
                    }
                    else
                        System.out.println("Can't delete");
                    break;
                default:
                    System.out.println("Invalid entry");
            }  // end switch
        }  // end while
    }  // end main()
    //--------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    //-------------------------------------------------------------
    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
//-------------------------------------------------------------
}  // end class InterIterApp
////////////////////////////////////////////////////////////////
