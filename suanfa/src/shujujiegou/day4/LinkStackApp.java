package shujujiegou.day4;

import shujujiegou.day4.Link;
import shujujiegou.day4.LinkList;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/8
 * \* Time: 15:46
 */
//链表实现栈
class LinkStack{
    private LinkList linkList;
    
    public LinkStack(){
        linkList=new LinkList();
    }
    
    public boolean isEmpty(){
        return linkList.isEmpty();
    }
    
    public void push(int key,double value){
        linkList.insertFirst(key,value);
    }
    
    public Link pop(){
       return linkList.deleteFirst();
    }
    
    public void display(){
        System.out.print("栈的");
        linkList.displayLinkList();
    }
}
public class LinkStackApp {

    public static void main(String[] args) {
        
        LinkStack ls=new LinkStack();
        ls.push(11,22.0);
        ls.push(22,33.0);
        ls.push(33,44.0);
        ls.display();
        while (!ls.isEmpty()){
            ls.pop().displayLink();
        }
        System.out.println();
        ls.display();
    }
}
