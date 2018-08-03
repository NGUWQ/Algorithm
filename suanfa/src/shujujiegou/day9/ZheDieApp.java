package shujujiegou.day9;

import java.io.IOException;

import static utils.Get.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/25
 * \* Time: 18:02
 */
//写一个哈希函数,实现数字折叠的方法(例:123456789 ,
// 容量1000的数组就是123+456+789,容量100的数组就是12+34+56+78+9)。算法见hashtable类
public class ZheDieApp {
    public static void main(String[] args) throws IOException {

        System.out.println("1.哈希表的显示(s or S)");
        System.out.println("2.哈希表数据的添加(i or I)");
        System.out.println("3.哈希表数据的查找(f or F)");
        System.out.println("4.哈希表数据的删除(d or D)");
        System.out.println("5.退出程序(q or Q)");
        System.out.println("请输入哈希表的大小(size):");
        int size = getValue();
        Hashtable hashtable = new Hashtable(size);
        while (true) {
            System.out.println("您想怎么操作哈希表呢?");
            char choice = getChoice();
            if (choice == 'q' || choice == 'Q')
                break;
            else if (choice == 's' || choice == 'S') {
                hashtable.displayTable();
            }
            else if (choice == 'd' || choice == 'D') {
                hashtable.displayTable();
                System.out.println("请输入要删除的值:");
                int value = getValue();
                Data data = hashtable.delete(value);
                if (data == null)
                    System.out.println("没有此数据,删除失败！！！");
                else
                    hashtable.displayTable();
            }
            else if (choice == 'i' || choice == 'I') {
                System.out.println("请输入要添加的值:");
                int value = getValue();
                Data data=new Data(value);
                hashtable.insert(data);
                System.out.println(value+"添加成功");
                hashtable.displayTable();
            }
            else if (choice == 'f' || choice == 'F') {
                int value = getValue();
                Data data = hashtable.find(value);
                if (data==null)
                    System.out.println("查无此值!!!");
                else
                    System.out.println("已找到值"+value);
            }
            else
                System.out.println("请重新输入!!!");

        }

    }
}
