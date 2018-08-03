package shujujiegou.day3;

import shujujiegou.day3.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/7
 * \* Time: 1:06
 */
//编程作业4.5
class Utility{
    //接收键盘输入字符串
    public static String getString() throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader buf=new BufferedReader(in);
        String s=buf.readLine();
        return s;

    }
}
public class SuperMarketApp {
    private Queue[] queues={null,new Queue(5),new Queue(5),
            new Queue(5),new Queue(5)};//4个顾客队列

    //模拟收银
    public void simulate() throws IOException {
        long id=0;//顾客编号
        boolean flag=true;
        while (flag){
            System.out.println("请选择事件:");
            System.out.println("0.有顾客进入某个队列。");
            System.out.println("1.有顾客离开第1个队列。");
            System.out.println("2.有顾客离开第2个队列。");
            System.out.println("3.有顾客离开第3个队列。");
            System.out.println("4.有顾客离开第4个队列。");
            System.out.println("e.表示程序退出！");
            String s=Utility.getString();
            if(s.length()==0)
                continue;//如果用户没有输入，则继续输入。
            char ch=s.charAt(0);
            switch (ch){
                case '0':
                    ++id;
                    insertQueue(id);//顾客进入队列
                    displayQueue();//显示队列
                    break;
                case '1':
                    removeQueue(1);//顾客离开队列
                    displayQueue();
                    break;
                case '2':
                    removeQueue(2);//顾客离开队列
                    displayQueue();
                    break;
                case '3':
                    removeQueue(3);//顾客离开队列
                    displayQueue();
                    break;
                case '4':
                    removeQueue(4);//顾客离开队列
                    displayQueue();
                    break;
                case 'e':
                case 'E'://退出程序
                    flag=false;
                    System.out.println("byebye!");
                    break;
                default:
                    break;

        }
    }


}
    //从队列中删除顾客
    private void removeQueue(int i) {
        if(queues[i].size()==0) {
            return;
        }
        long id=queues[i].remove();
        System.out.println("顾客"+id+"离开第"+i+"个队列！");
    }
    //显示所有的队列
    private void displayQueue() {
        for(int i=1;i<5;i++){
            System.out.print("第"+i+"个");
            queues[i].display();
        }
    }
    //将顾客插入到队列
    private void insertQueue(long id) {
        int queueId=getMinQueueId();
        queues[queueId].insert(id);
        System.out.println("顾客"+id+"进入第"+queueId+"个队列！");
    }
    //得到最小队列的编号
    private int getMinQueueId() {
        int min=1;
        for(int i=2;i<5;i++){
            if(queues[i].size()<queues[min].size())
                min=i;
        }
        return min;
    }

    public static void main(String[] args) {

        SuperMarketApp s=new SuperMarketApp();
        try {
            s.simulate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
