package shujujiegou.day9;
import static utils.Get.*;

import java.io.IOException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/25
 * \* Time: 13:08
 */
//编程作业11.2线性探索哈希表存储字符串
class LinkWords{

    private  String word;
    public LinkWords next;

    public LinkWords(String word){
        this.word=word;
    }

    public String getWord() {
        return word;
    }
    public void displayWords(){
                System.out.print(word+" ");
        }
}

class SortList {

    private LinkWords first;

    public SortList() {
        first = null;
    }

    public void insert(LinkWords linkWords) {
        String words = linkWords.getWord();
        LinkWords previous = null;
        LinkWords current = first;

        while (current != null && (words.compareTo(current.getWord()) > 0)) {
            previous = current;
            current = current.next;
        }

        if (previous == null)
            first = linkWords;
        else
            previous.next = linkWords;
        linkWords.next = current;
    }

    public void delete(String words) {
        LinkWords previous = null;
        LinkWords current = first;
        while (current != null && (!words.equals(current.getWord()))) {
            previous = current;
            current = current.next;
        }
        if (previous == null)
            first = first.next;
        else
            previous.next = current.next;
    }

    public LinkWords find(String words) {
        LinkWords current = first;
        while (current != null && (words.compareTo(current.getWord()) <= 0)) {
            if (words.compareTo(current.getWord()) == 0)
                return current;
            current = current.next;
        }
        return null;
    }

    public void show(){
        LinkWords current = first;
        while (current!=null){
            current.displayWords();
            current=current.next;
        }
        System.out.println();
    }
}
class HashWords{

    private SortList[] array;
    private int size;


    public HashWords(int size){
        this.size=size;
        array=new SortList[size];
        for (int j=0;j<size;j++)
            array[j]=new SortList();
    }

    public void showWords(){
        for (int j=0;j<size;j++)
        {
            System.out.println(j+".");
            array[j].show();
        }
    }

    public  int method(String string){
        string=string.toLowerCase();
        int hashcode=0;
        for (int i=0;i<string.length();i++)
        {
            int letter=string.charAt(i)-96;
            hashcode=(hashcode*27+letter)%size;
        }
        return hashcode;
    }

    public void insert(LinkWords linkWords){
        String words=linkWords.getWord();
        int hashcode=method(words);
        array[hashcode].insert(linkWords);
    }

    public void delete(String words){
        int hashcode=method(words);
        array[hashcode].delete(words);
    }

    public LinkWords find(String words){
        int hashcode=method(words);
        LinkWords linkWords=array[hashcode].find(words);
        return linkWords;
    }
}
public class HashWordsApp {

    public static void main(String[] args) throws IOException {
        System.out.println("1.哈希表的显示(s or S)");
        System.out.println("2.哈希表数据的添加(i or I)");
        System.out.println("3.哈希表数据的查找(f or F)");
        System.out.println("4.哈希表数据的删除(d or D)");
        System.out.println("5.退出程序(q or Q)");
        System.out.println("请输入哈希表的大小(size):");
        int size= getValue();

        HashWords hashWords = new  HashWords(size);
        while (true) {
            System.out.println("您想怎么操作哈希表呢?");
            char choice = getChoice();
            if (choice == 'q' || choice == 'Q')
                break;
            else if (choice == 's' || choice == 'S') {
                hashWords.showWords();
            }
            else if (choice == 'd' || choice == 'D') {
                hashWords.showWords();
                System.out.println("请输入要删除的值:");
                String string = getString();
                hashWords.delete(string);
                hashWords.showWords();
            }
            else if (choice == 'i' || choice == 'I') {
                System.out.println("请输入要添加的值:");
                String string = getString();
               LinkWords linkWords=new LinkWords(string);
                hashWords.insert(linkWords);
                System.out.println(string+"添加成功");
                hashWords.showWords();
            }
            else if (choice == 'f' || choice == 'F') {
                System.out.println("请输入要查找的值:");
                String string = getString();
                LinkWords linkWords= hashWords.find(string);
                if (linkWords==null)
                    System.out.println("查无此值!!!");
                else
                    System.out.println("已找到值"+string);
            }
            else
                System.out.println("请重新输入!!!");

        }
    }
}
